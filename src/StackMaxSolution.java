//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
//public class StackMaxSolution {
//
//    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int n = Integer.parseInt(reader.readLine());
//            MyStack stack = new MyStack(n);
//            for (int i = 0; i < n; i++) {
//                String command = reader.readLine();
//
//                if (command.contains("pop")) {
//                    stack.pop();
//                } else if (command.contains("push")) {
//                    stack.push(Integer.parseInt(command.split(" ")[1]));
//                } else {
//                    stack.getMax();
//                }
//
//            }
//        }
//    }
//}
//
//class MyStack {
//    private Integer[] store;
//    private int pointer = 0;
//    Node max = null;
//
//    public MyStack(int n) {
//        store = new Integer[n];
//    }
//
//    public void push(int x) {
//        if (max == null || max.value <= x) {
//            max = new Node(x, max);
//        }
//        store[pointer] = x;
//        pointer++;
//    }
//
//    public void pop() {
//        if (pointer > 0) {
//            pointer--;
//            if (max.value==store[pointer]){
//                max = max.prevous;
//            }
//            store[pointer] = null;
//        } else {
//            System.out.println("error");
//        }
//    }
//
//
//    public void getMax() {
//        if (max == null) {
//            System.out.println("None");
//        } else {
//            System.out.println(max.value);
//        }
//    }
//
//
//}
//
//class Node {
//    int value;
//    Node prevous;
//
//    public Node(int value, Node prevous) {
//        this.value = value;
//        this.prevous = prevous;
//    }
//}
