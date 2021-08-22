package homework8;

import java.util.NoSuchElementException;

public class MyStack<T> extends MyLinkedList<T> {

    public T peek(){
        if(size == 0){
            throw new NoSuchElementException("The stack is empty");
        }

        return tail.data;
    }

    public T pop(){
        if (size == 0){
            throw new NoSuchElementException("The stack is empty");
        }

        Node<T> temp = tail;
        tail = temp.prev;
        if(tail != null){
            tail.next = null;
        }

        size--;

        return temp.data;
    }
}
