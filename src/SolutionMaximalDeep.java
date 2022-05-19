//public class Solution {
//    public static int treeSolution(Node head) {
//       return deeper(head, 0);
//    }
//        private static int deeper(Node node, int deep) {
//        if (node == null) {
//            return deep;
//        }
//        int l = deeper(node.left, deep + 1);
//        int r = deeper(node.right, deep + 1);
//        if (l > r) {
//            return l;
//        } else {
//            return r;
//        }
//    }
//
//    /** Comment it before submitting
//
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
//    private static void main(String[] a) {
//        Node node1 = new Node(1, null, null);
//        Node node2 = new Node(4, null, null);
//        Node node3 = new Node(3, node1, node2);
//        Node node4 = new Node(8, null, null);
//        Node node5 = new Node(5, node3, node4);
//        System.out.println( treeSolution(node5) );
//    }
//}
