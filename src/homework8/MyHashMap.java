package homework8;

import java.util.NoSuchElementException;

public class MyHashMap<K,V> {
    private Node<K,V> head = null;
    private int size = 0;

    public boolean put(Object key, Object value){
        try {
            if(size == 0){
                head = new Node<K,V>((K) key, (V) value, null);
                size++;
                return true;
            }

            Node<K,V> temp = new Node<K,V>((K) key, (V) value, head.next);
            if(!contains(temp)) {
                head.next = temp;
                size++;
                return true;
            }
        } catch (ClassCastException ex){
            System.err.println("The element couldn't be added to the map.");
        }

        return false;
    }

    public boolean remove(Object key){
        if(size == 0){
            System.err.println("The map is empty. Deletion impossible.");
            return false;
        }

        try {
            Node<K,V> temp = new Node<>((K) key, null ,null);
            if(!contains(temp)){
                System.err.println("The key is not found");
                return false;
            }

            temp = head;
            Node<K,V> prev = null;
            while (temp != null){
                if(temp.key.equals((K) key)){
                    if(prev != null){
                        prev.next = temp.next;
                    } else {
                        if(size == 1) {
                            head = null;
                            size = 0;
                        } else {
                            head = head.next;
                            size--;
                        }
                        return true;
                    }
                }
                prev = temp;
                temp = temp.next;
            }
            size--;
            return true;
        } catch (ClassCastException ex){
            System.err.println("The element couldn't be deleted.");
        }
        return false;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public V get(Object k){
        if(size == 0){
            throw new NoSuchElementException("The map is empty.");
        }

        try {
            Node<K,V> temp = head;
            while (temp != null){
                if(temp.key.equals((K) k)){
                    return temp.value;
                }
                temp = temp.next;
            }
        } catch (ClassCastException ex){
            System.err.println("The element couldn't be returned.");
        }

        throw new NoSuchElementException("No such element found");
    }

    private boolean contains(Node<K,V> entry){
        if(size == 0)
            return false;
        Node<K,V> temp = head;
        while(temp != null){
            if(temp.key.equals(entry.key)){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    private class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next;

        Node(K key, V value, Node<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        Node<K,V> temp = head;
        while (temp != null){
            sb.append(temp.key + ":" + temp.value);
            if(temp.next != null){
                sb.append(" ");

            }
            temp = temp.next;
        }
        return sb.toString();
    }
}
