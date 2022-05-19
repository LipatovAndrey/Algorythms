import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ListQueueSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commands = Integer.parseInt(reader.readLine());
            MyListQueue queue = new MyListQueue();
            for (int i = 0; i < commands; i++) {
                String command = reader.readLine();

                if (command.contains("get")) {
                    queue.get();
                } else if (command.contains("put")) {
                    queue.put(Integer.parseInt(command.split(" ")[1]));
                } else {
                    queue.getSize();
                }
            }
        }
    }
}

class MyListQueue {
    private Node head = null;
    private Node tail = null;
    int length = 0;

    public MyListQueue() {

    }

    public void put(int x) {
        if (length == 0) {
            Node tailNode = new Node();
            head = tailNode;
            tail = tailNode;
            tailNode.value = x;
            length++;
        } else {
            Node tailNode = new Node();
            tail.next = tailNode;
            tailNode.previous = tail;
            tailNode.value = x;
            tail = tailNode;
            length++;
        }
    }

    public void get() {
        if (length != 0) {
            System.out.println(head.value);
            head = head.next;
            length--;
        } else {
            System.out.println("error");
        }
    }


    public void getSize() {
        System.out.println(length);
    }
}

class Node {
    Node previous;
    Node next;
    int value;
}

