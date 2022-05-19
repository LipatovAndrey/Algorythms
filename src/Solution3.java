//public class Solution {
//    public static boolean treeSolution(Node head) {
//        return isBinarySearch(head);
//    }
//
//    public static boolean isBinarySearch(Node head) {
//        boolean isBinarySearch = true;
//        if (head.left != null) {
//            if (!isBinarySearch(head.left)) {
//                isBinarySearch = false;
//            }
//            if (head.left.value>= head.value){
//                isBinarySearch = false;
//            }
//        }
//        if (head.right != null) {
//            if (!isBinarySearch(head.right)) {
//                isBinarySearch = false;
//            }
//            if (head.right.value<= head.value){
//                isBinarySearch = false;
//            }
//        }
//        return isBinarySearch;
//    }
//
//
//    /**
//     * Comment it before submitting
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
//
//     **/
//    private static void main(String[] a) {
//        Node node5 = new Node(6, null, null);
//        Node node6 = new Node(9, null, null);
//        Node node3 = new Node(1, null, null);
//        Node node4 = new Node(4, null, null);
//        Node node1 = new Node(3, node3, node4);
//        Node node2 = new Node(8, node5, node6);
//        Node node0 = new Node(5, node1, node2);
//        System.out.println(treeSolution(node0));
//    }
//}
