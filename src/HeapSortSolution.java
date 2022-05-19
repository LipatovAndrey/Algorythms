import java.io.*;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

/*
Принцип работы

Создается бинарная куча размера несортированого массива + 1, так как на 0 индексе фиктивный элемент
затем из несортированного массива в кучу добавляются все элементы,
после чего из кучи достается элемент с наибольшим приоритетом, и кладется в новый отсортированный массив. после каждого удаления элемента выполняется просеивание вниз,
что гарантирует сортированность массива

Временная сложность O(nLogn) в худшем случае, так как необходимо сначала добавить n элементов в кучу (для этого нужно 1 выделить память затем после каждого добавления выполнить просеивание вверх)
затем n раз удалить из кучи элемент выполнив просеивание вниз для каждого удаления элемента. так как просеивание вниз и вверх происходит за логарифмическое время, то итоговая сложность O(nlogn)

Пространственная сложность O(n) так как для сортировки требуется массив размера n+1 и результирующий массив размера n

https://contest.yandex.ru/contest/24810/run-report/68156912/
*/
public class HeapSortSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int members = Integer.parseInt(reader.readLine());
            Participant[] unsorted = new Participant[members];
            for (int i = 0; i < members; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String login = tokenizer.nextToken();
                Integer p = Integer.parseInt(tokenizer.nextToken());
                Integer f = Integer.parseInt(tokenizer.nextToken());
                Participant participant = new Participant(login, p, f);
                unsorted[i] = participant;
            }
            Participant[] sorted = heapSort(unsorted, Participant[].class);
            for (int i = 0; i < sorted.length; i++) {
                writer.write(sorted[i].getLogin());
                writer.newLine();
            }
            writer.flush();
        }
    }

    private static <T extends Comparable<? super T>> T[] heapSort(T[] unsorted, Class<T[]> clazz) {
        Heap<T> heap = new Heap(clazz.cast(Array.newInstance(clazz.getComponentType(), unsorted.length + 1)));
        for (int i = 0; i < unsorted.length; i++) {
            heap.add(unsorted[i]);
        }

        int sortedIndex = 0;
        T[] sorted = clazz.cast(Array.newInstance(clazz.getComponentType(), unsorted.length ));
        while (!heap.isEmpty()) {
            sorted[sortedIndex] = heap.poll();
            sortedIndex++;
        }
        return sorted;
    }
}

class Participant implements Comparable<Participant> {

    private String login;
    private Integer p;
    private Integer f;

    public Participant(String login, Integer p, Integer f) {
        this.login = login;
        this.p = p;
        this.f = f;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public int compareTo(Participant o) {
        if (this.p.compareTo(o.p) != 0) {
            return this.p.compareTo(o.p);
        } else {
            if (this.f.compareTo(o.f) != 0) {
                return o.f.compareTo(this.f);
            } else {
                return o.login.compareTo(this.login);
            }
        }
    }
}

class Heap<T extends Comparable<? super T>> {

    private T[] store;
    private int currentSize;

    public Heap(T[] store) {
        this.store = store;
        this.currentSize = 0;
    }

    public Boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public T poll() {
        T firstElement = store[1];
        store[1] = store[currentSize];
        currentSize--;
        siftDown(1);
        return firstElement;
    }

    public void add(T element) {
        currentSize++;
        store[currentSize] = element;
        siftUp(currentSize);
    }

    private void siftUp(Integer index) {
        if (index == 1) {
            return;
        }

        int parentIndex = index / 2;
        if (store[parentIndex].compareTo(store[index]) < 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    private void siftDown(Integer parentIndex) {
        int leftIndex = 2 * parentIndex;
        int rightIndex = 2 * parentIndex + 1;

        if (currentSize < leftIndex) {
            return;
        }
        int largestIndex = leftIndex;
        if (rightIndex <= currentSize) {
            if (store[rightIndex].compareTo(store[leftIndex]) > 0) {
                largestIndex = rightIndex;
            }
        }

        if (store[parentIndex].compareTo(store[largestIndex]) < 0) {
            swap(largestIndex, parentIndex);
            siftDown(largestIndex);
        }
    }

    private void swap(Integer firstIndex, Integer secondIndex) {
        T second = store[secondIndex];
        store[secondIndex] = store[firstIndex];
        store[firstIndex] = second;
    }
}