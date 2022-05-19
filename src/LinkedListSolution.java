///*
//Comment it before submitting
//
//
//
//class Node<V> {
//    public V value;
//    public Node<V> next;
//    public Node<V> prev;
//
//    public Node(V value, Node<V> next, Node<V> prev) {
//        this.value = value;
//        this.next = next;
//        this.prev = prev;
//    }
//}
// */
//public class Solution {
//    public static Node<String> solution(Node<String> head) {
//        Node<String> prev = head.prev;
//        Node<String> next = head.next;
//        while (next != null) {
//            prev = head.prev;
//            next = head.next;
//            head.prev = next;
//            head.next = prev;
//            if (next!=null){
//                head = next;
//            }
//        }
//
//        return head;
//    }
//
//}
