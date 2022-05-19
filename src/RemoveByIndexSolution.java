///*
//Comment if before submitting
//
//
//class Node<V> {
//    public V value;
//    public Node<V> next;
//
//    public Node(V value, Node<V> next) {
//        this.value = value;
//        this.next = next;
//    }
//}
// */
//
//public class RemoveByIndexSolution {
//    public static Node<String> solution(Node<String> head, int idx) {
//        int index = 0;
//        Node<String> previous = null;
//        Node<String> current = head;
//        while (index <= idx){
//            if (previous!= null && index == idx){
//                previous.next = current.next;
//            }
//            previous = current;
//            current = current.next;
//            index++;
//        }
//        return head;
//    }
//}
