//import java.util.Stack;
//
//public class Solution {
//    public static int treeSolution(Node head) {
//        Stack<String> stack = new Stack<>();
//        stack.push(String.valueOf(head.value));
//        deeper(head, stack);
//        int result = 0;
//        for (String s: stack
//             ) {
//            result = result + Integer.parseInt(s);
//        }
//        return result;
//    }
//
//    private static void deeper(Node node, Stack<String> deep) {
//        if (node == null) {
//            return;
//        }
//        String a = deep.peek();
//        if (node.left!=null|| node.right!=null){
//            deep.pop();
//        }
//
//        if (node.left!=null){
//            deep.push(a + String.valueOf(node.left.value));
//            deeper(node.left, deep);
//        }
//
//        if (node.right!=null){
//            deep.push(a + String.valueOf(node.right.value));
//            deeper(node.right, deep);
//        }
//
//
//    }
//
//    /** Comment it before submitting
//    private static class Node {
//        int value;
//        Node left;
//        Node right;
//
//        Node(int value) {
//            this.value = value;
//            this.left = null;
//            this.right = null;
//        }
//
//        Node(int value, Node left, Node right) {
//            this.value = value;
//            this.left = left;
//            this.right = right;
//        }
//    }
//     **/
//
//    private static void main(String[] a) {
//        Node node1 = new Node(2, null, null);
//        Node node2 = new Node(1, null, null);
//        Node node3 = new Node(3, node1, node2);
//        Node node4 = new Node(2, null, null);
//        Node node5 = new Node(1, node4, node3);
//        System.out.println(treeSolution(node5));
//    }
//}
