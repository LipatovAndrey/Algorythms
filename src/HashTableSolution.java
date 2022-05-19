import java.io.*;
import java.util.*;

/*
Принцип работы

В хеш-таблице используется массив объектов содержащих ключ значение и ссылку на следующий и предыдущий элемент
по ключу считается хеш и из него определяется индекс элемента в массиве, остатком отделения ключа на размер массива
Для разрешения коллизий я выбрал метод цепочек
в случае если при добавлении по индексу есть элемент, то идем по цепочке элементов и вставляем новый элемент в конец

при получении элемента по ключу вычисляем индекс и итерируемся по цепочке элементов пока ключ не будет равен искомому
при удалении находим элемент так же как и при получении по ключу, затем удаляем ссылку на удаляемый элемент с предыдущего элемента
и проставляем на следующий элемент, если он существует

временная сложность
худшая сложность получения, удаления и вставки элемента О(n) - если все элементы будут попадать в один бакет
средняя сложность получения, удаления и вставки элемента О(1) так как если ключи будут распределены равномерно,
то итерироваться по цепочке элементов нужно будет достаточно редко, а в остальных случаях будет доступ к массиву по индексу

Пространственная сложность
для сохранения значения в бакет необходимо О(1) -неизменное количество памяти для сохранения указателя на следующий и предыдущий элемент,
а так же для хранения значения. место потребляемое для сохранения всех бакетов зависит от количества элементов О(n)
следовательно пространственная сложность О(n)
https://contest.yandex.ru/contest/24414/run-report/66799635/
*/
public class HashTableSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            int capacity = 10;
            if (n > capacity) {
                capacity = n / 10;
            }
            HashTable hashTable = new HashTable(capacity);
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                String command = tokenizer.nextToken();
                if (command.equals("get")) {
                    Integer value = hashTable.get(Integer.parseInt(tokenizer.nextToken()));
                    if (value == null) {
                        writer.write("None");
                    } else {
                        writer.write(value.toString());
                    }
                    writer.newLine();
                }
                if (command.equals("put")) {
                    hashTable.put(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
                }
                if (command.equals("delete")) {
                    Integer value = hashTable.delete(Integer.parseInt(tokenizer.nextToken()));
                    if (value == null) {
                        writer.write("None");
                    } else {
                        writer.write(value.toString());
                    }
                    writer.newLine();
                }
            }
            writer.flush();
        }
    }
}

class HashTable {

    private Pair[] store;

    private Integer capacity;

    public HashTable(Integer capacity) {
        this.capacity = capacity;
        this.store = new Pair[capacity];
    }

    public Integer get(Integer key) {
        Pair firstPair = getFirstPairByKey(key);
        if (firstPair != null) {
            Pair target = findByKey(firstPair, key);
            if (target != null) {
                return target.getValue();
            }
        }
        return null;
    }

    public void put(Integer key, Integer value) {
        Pair firstPair = getFirstPairByKey(key);
        if (firstPair == null) {
            store[calculateIndexByKey(key)] = new Pair(key, value);
        } else {
            Pair target = findByKey(firstPair, key);
            if (target != null) {
                target.setValue(value);
            } else {
                Pair last = findLast(firstPair);
                Pair added = new Pair(key, value);
                last.setNext(added);
                added.setPrevious(last);
            }
        }
    }

    public Integer delete(Integer key) {
        Pair firstPair = getFirstPairByKey(key);
        if (firstPair != null) {
            Pair target = findByKey(firstPair, key);
            if (target != null) {
                if (target.hasPrevious()) {
                    Pair previous = target.getPrevious();
                    previous.setNext(target.getNext());
                    if (target.hasNext()) {
                        target.getNext().setPrevious(target.getPrevious());
                    }
                } else {
                    if (target.hasNext()) {
                        store[calculateIndexByKey(key)] = target.getNext();
                    } else {
                        store[calculateIndexByKey(key)] = null;
                    }
                }
                return target.getValue();
            }
        }
        return null;
    }


    private Pair getFirstPairByKey(Integer key) {
        Integer index = calculateIndexByKey(key);
        return store[index];
    }

    private Pair findByKey(Pair pair, Integer key) {
        if (pair.getKey().equals(key)) {
            return pair;
        }
        while (pair.hasNext()) {
            Pair next = pair.getNext();
            if (next.getKey().equals(key)) {
                return next;
            }
            pair = next;
        }
        return null;
    }

    private Pair findLast(Pair pair) {
        while (pair.hasNext()) {
            Pair next = pair.getNext();
            pair = next;
        }
        return pair;
    }

    private Integer calculateIndexByKey(Integer key) {
        return getHash(key) % capacity;
    }

    private Integer getHash(Integer key){
        return key.hashCode();
    }
}

class Pair {

    private Integer key;
    private Integer value;
    private Pair previous;
    private Pair next;

    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public boolean hasPrevious() {
        if (this.previous != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNext() {
        if (this.next != null) {
            return true;
        } else {
            return false;
        }
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Pair getPrevious() {
        return previous;
    }

    public void setPrevious(Pair previous) {
        this.previous = previous;
    }

    public Pair getNext() {
        return next;
    }

    public void setNext(Pair next) {
        this.next = next;
    }

    public Integer getKey() {
        return key;
    }
}
