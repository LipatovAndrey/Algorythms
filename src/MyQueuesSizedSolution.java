//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
//public class MyQueuesSizedSolution {
//
//    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int commands = Integer.parseInt(reader.readLine());
//            int n = Integer.parseInt(reader.readLine());
//            MyQueue stack = new MyQueue(n);
//            for (int i = 0; i < commands; i++) {
//                String command = reader.readLine();
//
//                if (command.contains("pop")) {
//                    stack.pop();
//                } else if (command.contains("push")) {
//                    stack.push(Integer.parseInt(command.split(" ")[1]));
//                } else if (command.contains("peek")) {
//                    stack.peek();
//                } else {
//                    stack.getSize();
//                }
//            }
//        }
//    }
//}
//
//class MyQueue {
//    private Integer[] store;
//    private int headPointer = 0;
//    private int tailPointer = 0;
//    int length = 0;
//
//    public MyQueue(int n) {
//        store = new Integer[n];
//    }
//
//    public void put(int x) {
//        if (length > store.length-1) {
//            System.out.println("error");
//        } else {
//
//            store[tailPointer] = x;
//            if (tailPointer==store.length-1){
//                tailPointer = 0;
//            }else {
//                tailPointer++;
//            }
//            length++;
//        }
//    }
//
//    public void get() {
//        if (length != 0) {
//            System.out.println(store[headPointer]);
//            store[headPointer] = null;
//            if (headPointer==store.length-1){
//                headPointer = 0;
//            }else {
//                headPointer++;
//            }
//
//            length--;
//        } else {
//            System.out.println("None");
//        }
//    }
//
//    public void size() {
//        System.out.println(length);
//    }
//}
//
