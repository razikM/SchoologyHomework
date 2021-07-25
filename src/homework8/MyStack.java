package homework8;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public boolean push(Object value){
        try{
            if(size == 0){
                Node<T> temp = new Node<>((T) value, null,null);
                head = temp;
                tail = temp;
                size++;
                return true;
            }
            Node<T> temp = new Node<>((T) value, null,tail);
            tail.next = temp;
            tail = temp;
            size++;
            return true;
        } catch (ClassCastException ex){
            System.err.println("The element could not be added");
        }

        return false;
    }

    public boolean remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("The index is invalid. No such element.");
        }

        Node<T> temp = tail;

        for(int i = 0; i < index; i++){
            temp = temp.prev;
        }

        if(index == 0){
            head = temp.next;
        } else if(index == size - 1){
            tail = temp.prev;
        }

        if(temp.prev != null){
            temp.prev.next = temp.next;
        }

        if(temp.next != null){
            temp.next.prev = temp.prev;
        }

        size--;

        return true;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

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

        return temp.data;
    }

    private class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        Node<T> temp = head;

        while(temp != null){
            sb.append(temp.data.toString());
            if(temp.next != null){
                sb.append(" ");
            }
            temp = temp.next;
        }

        return sb.toString();
    }
}
