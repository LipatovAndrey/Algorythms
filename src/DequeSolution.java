import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Принцип работы

Создаем 2х стороннюю очередь содержащую 2 указателя на голову и хвост очереди и массив для хранения элементов
В методах добавляющих элемент pushFront и pushBack сначала проверяется количество элементов
очереди на превышение размера массива.
При добавлении элемента в начало указатель головы очереди с двигается влево,
при добавлении в конец очереди указатель хвоста очереди сдвигается вправо.
При удалении элемента с начала очереди указатель головы с двигается наоборот вправо,
а при удалении элемента с конца очереди указатель хвоста сдвигается влево.
если указатель преступает границу начала массива, то он становится на последнюю ячейку массива,
а если преступает границу конца массива, то он становится на первую ячейку массива.

Временная сложность добавления или удаления элемента О(1) так как добавление в массив происходит по индексу
и при удалении не требуется перестановок внутри массива, а только изменить значение указателя
Временная сложность работы программы O(n) так как
для того чтобы обработать входные данные размера n следует n раз выполнить константное количество операций

Пространственная сложность O(1) так как размер массива постоянен и задается при создании

https://contest.yandex.ru/contest/22781/run-report/65918089/
*/
public class DequeSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commands = Integer.parseInt(reader.readLine());
            int dequeSize = Integer.parseInt(reader.readLine());
            DeQueue deque = new DeQueue(dequeSize);
            for (int i = 0; i < commands; i++) {
                String command = reader.readLine();
                if (command.contains("push_front")) {
                    deque.pushFront(Integer.parseInt(command.split(" ")[1]));
                } else if (command.contains("push_back")) {
                    deque.pushBack(Integer.parseInt(command.split(" ")[1]));
                } else if (command.contains("pop_front")) {
                    Integer el = deque.popFront();
                    if (el == null){
                        System.out.println("error");
                    }else {
                        System.out.println(el);
                    }
                } else if (command.contains("pop_back")) {
                    Integer el = deque.popBack();
                    if (el == null){
                        System.out.println("error");
                    }else {
                        System.out.println(el);
                    }
                } else {
                    throw new IllegalStateException("Unexpected value: " + command);
                }
            }
        }
    }
}

class DeQueue {
    private Integer[] store;

    private int pointer = 0;
    private int previous = 0;
    private int length = 0;

    public DeQueue(int n) {
        store = new Integer[n];
    }

    public void pushBack(int x) {
        if (!isFull()) {
            pointer++;
            if (pointer > store.length - 1) {
                pointer = 0;
            }
            store[pointer] = x;
            length++;
        } else {
            System.out.println("error");
        }
    }

    public void pushFront(int x) {
        if (!isFull()) {
            store[previous] = x;
            previous--;
            if (previous < 0) {
                previous = store.length -1;
            }
            length++;
        } else {
            System.out.println("error");
        }
    }

    private boolean isFull() {
        if (length > store.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public Integer popFront() {
        if (!isEmpty()) {
            length--;
            previous++;
            if (previous > store.length - 1) {
                previous = 0;
            }
            return store[previous];
        } else {
            return null;
        }
    }

    public Integer popBack() {
        if (!isEmpty()) {
            Integer el = store[pointer];
            pointer--;
            length--;
            if (pointer < 0) {
                pointer = store.length - 1;
            }
            return el;
        } else {
            return null;
        }
    }

    private boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }
}