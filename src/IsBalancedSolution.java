//public class IsBalancedSolution {
//    public static boolean treeSolution(Node head) {
//        boolean isBalanced = isBalanced(head);
//        if (isBalanced){
//            Node left = head.left;
//            while (left!=null){
//                if (!isBalanced(left)){
//                    isBalanced = false;
//                }
//                left = left.left;
//            }
//            Node right = head.right;
//            while (right!=null){
//                if (!isBalanced(right)){
//                    isBalanced = false;
//                }
//                right = right.right;
//            }
//        }
//        return isBalanced;
//    }
//
//    public static boolean isBalanced(Node head) {
//        int l = deeper(head.left, 0);
//        int r = deeper(head.right, 0);
//        if (l - r > 1 || r - l > 1) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//
//    //нужно этот момент проработать для каждой вершины
//    private static int deeper(Node node, int deep) {
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
//    }
//
//     **/
//    private static void main(String[] a) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(-5);
//        Node node3 = new Node(3);
//        node3.left = node1;
//        node3.right = node2;
//        Node node4 = new Node(10);
//        Node node5 = new Node(2);
//        node5.left = node3;
//        node5.right = node4;
//        System.out.println(treeSolution(node5));
//    }
//}
