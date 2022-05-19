//public class Solution2 {
//    public static int treeSolution(Node head) {
//        return findMax(head);
//    }
//
//    public static int findMax(Node node) {
//        int max = node.value;
//        if (hasDeeper(node)) {
//            if (node.left!=null){
//                Integer left = findMax(node.left);
//                if (left != null && left > max) {
//                    max = left;
//                }
//            }
//            if (node.right!=null){
//                Integer right = findMax(node.right);
//
//                if (right != null && right > max) {
//                    max = right;
//                }
//            }
//
//        }
//        return max;
//    }
//
//    private static boolean hasDeeper(Node node) {
//        if (node.left != null || node.right != null) {
//            return true;
//        }
//        return false;
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
//    }
//
//
//    public static void main(String[] a) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        node3.left = node1;
//        node3.right = node2;
//        Node node4 = new Node(2);
//        node4.left = node3;
//        System.out.println( treeSolution(node4) );
//    }*/
//}
