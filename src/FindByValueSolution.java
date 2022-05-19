/*
Comment it before submitting


class Node<V> {  
    public V value;  
    public Node<V> next;  
 
    public Node(V value, Node<V> next) {  
        this.value = value;  
        this.next = next;  
    }  
}

public class FindByValueSolution {
    public static int solution(Node<String> head, String elem) {
        int index = 0;
        while (head.next!=null){
            if (head.value.equals(elem)){
                return index;
            }
            head = head.next;
            index++;
        }
        return -1;
    }
}
*/