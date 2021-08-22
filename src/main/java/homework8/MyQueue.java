package homework8;

import java.util.NoSuchElementException;

public class MyQueue<T> extends MyLinkedList<T>{

    public T peek(){
        if (size != 0){
            return head.data;
        } else {
            throw new NoSuchElementException("The queue is empty");
        }
    }

    public T poll(){
        if (size != 0){
            Node<T> temp = head;
            head = temp.next;
            head.prev = null;
            size--;
            return temp.data;
        } else {
            throw new NoSuchElementException("The queue is empty");
        }
    }
}
