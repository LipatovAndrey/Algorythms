import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Принцип работы

Массив делится на 3 части опорный элемент элементы меньшие опорного и элементы большие опорного
затем рекурсино сортируются часть с меньшими и большими элементами и так до тех пор пока размер
в методе partition происходит перенос всех элементов меньших опорного влево, а больших вправо
для этого выбираем опорным первый элемент, 2 указателя с первой и последней позиции двигаем на встречу друг другу
если значение элемента левого указателя меньше значения опорного элемента, то такой элемент пропускаем(он находится на своем месте)
если значение элемента правого указателя больше значения опорного элемента, то такой элемент пропускаем(он находится на своем месте)
когда находятся 2 элемента, которые находятся не на своих местах левый больше опорного а правый меньше, то меняем их местами
когда правый указатель становится меньше левого, значит что все элементы находящиеся справа от него больше опорного
на это место устанавливаем опорный элемент

Для сравнения элементов используем метод compareTo который возвращает отрицательное значение если первый элемент больше второго и положительное если наоборот

Временная сложность O(n**2) в худшем случае, если на каждом шаге опорный элемент будет последним или первым по значению.
В таком случае каждый вызов сортировки будет уменьшать неотсортированую часть только на 1 опорный элемент, а для выполнения partition
нужно будет перебрать все элементы. В среднем сортировка будет происходить за O(nLogN)
так как при удачном выборе опорного элемента массив будет делиться на 2

Пространственная сложность O(logN) так как каждый рекурсиный вызов будет добавлять параметры функции в стек

https://contest.yandex.ru/contest/23815/run-report/66395435/
*/
public class QuickSortSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Person[] persons = new Person[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String name = tokenizer.nextToken();
                int p = Integer.parseInt(tokenizer.nextToken());
                int f = Integer.parseInt(tokenizer.nextToken());
                persons[i] = new Person(name, p, f);
            }

            quickSort(persons, 0, persons.length - 1);
            for (int i = n - 1; i >= 0; i--) {
                System.out.println(persons[i].getName());
            }
        }
    }

    private static void quickSort(Comparable[] persons, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivotIndex = partition(persons, left, right);
        quickSort(persons, pivotIndex + 1, right);
        quickSort(persons, left, pivotIndex - 1);
    }

    private static int partition(Comparable[] persons, int left, int right) {
        int pivot = left;
        int i = left, j = right + 1;
        while (true) {

            while (persons[++i].compareTo(persons[pivot]) > 0) {
                if (i == right) {
                    break;
                }
            }
            while (persons[pivot].compareTo(persons[--j]) > 0) {
                if (j == left) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(persons, i, j);

        }
        swap(persons, pivot, j);
        return j;
    }


    private static void swap(Comparable[] persons, int first, int second) {
        Comparable temp = persons[first];
        persons[first] = persons[second];
        persons[second] = temp;
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int p;
    private int f;

    public int getP() {
        return this.p;
    }

    public int getF() {
        return this.f;
    }

    public String getName() {
        return this.name;
    }

    public Person(String name, int p, int f) {
        this.name = name;
        this.p = p;
        this.f = f;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getP() == o.getP()) {
            if (this.getF() == o.getF()) {
                return this.name.compareTo(o.getName());
            }
            return Integer.compare(this.getF(), o.getF()) ;
        }
        return Integer.compare(o.getP() ,this.getP());
    }
}