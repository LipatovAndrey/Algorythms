//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class Solution {
//    public static void printRange(Node root, int L, int R, BufferedWriter writer) throws IOException {
//        if (root==null){return;}
//        if (root.getValue()>=L){
//            printRange(root.getLeft(), L, R, writer);
//        }
//
//
//        if (root.getValue()>=L && root.getValue()<=R){
//            writer.write(String.valueOf(root.getValue()));
//            writer.newLine();
//        }
//
//        if (root.getValue()<=R){
//            printRange(root.getRight(), L, R, writer);
//        }
//
//        writer.flush();
//
//    }
//
//
//    /**
//     * Comment it before submitting
//     * <p>
//
//     private static class Node {
//     private int value;
//     private Node left;
//     private Node right;
//
//     Node(Node left, Node right, int value) {
//     this.left = left;
//     this.right = right;
//     this.value = value;
//     }
//
//     public int getValue() {
//     return value;
//     }
//
//     public Node getRight() {
//     return right;
//     }
//
//     public void setRight(Node right) {
//     this.right = right;
//     }
//
//     public Node getLeft() {
//     return left;
//     }
//
//     public void setLeft(Node left) {
//     this.left = left;
//     }
//
//     public void setValue(int value) {
//     this.value = value;
//     }
//     }
//     **/
//    /**
//     * correctness
//     * 10
//     * 1 31 -1 2
//     * 2 624 3 7
//     * 3 220 4 5
//     * 4 130 -1 -1
//     * 5 302 -1 6
//     * 6 442 -1 -1
//     * 7 858 8 10
//     * 8 763 9 -1
//     * 9 701 -1 -1
//     * 10 867 -1 -1
//     * 448
//     * 763
//     *
//     * @param a
//     * @throws IOException
//     */
//    private static void main(String[] a) throws IOException {
//        Node node9 = new Node(null, null, 701);
//        Node node10 = new Node(null, null, 867);
//        Node node8 = new Node(node9, null, 763);
//        Node node7 = new Node(node8, node10, 858);
//
//        Node node6 = new Node(null, null, 442);
//        Node node5 = new Node(null, node6, 302);
//        Node node4 = new Node(null, null, 130);
//
//        Node node3 = new Node(node4, node5, 220);
//        Node node2 = new Node(node3, node7, 624);
//        Node node1 = new Node(null, node2, 31);
//
//
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        printRange(node1, 448, 763, writer);
//        writer.flush();
//        // expected output: 2 5 8 8
//    }
//}