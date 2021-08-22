package homework8;

public class MyLinkedList<T> {
    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected int size = 0;

    public boolean add(T value){
        try{
            if(size == 0){
                Node<T> temp = new Node<>(value, null,null);
                head = temp;
                tail = temp;
                size++;
                return true;
            }
            Node<T> temp = new Node<>(value, null,tail);
            tail.next = temp;
            tail = temp;
            size++;
            return true;
        } catch (ClassCastException ex){
            System.err.println("The elememen could not be added");
        }

        return false;
    }

    public boolean remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("The index is invalid. No such element.");
        }

        Node<T> temp = head;

        for(int i = 0; i < index; i++){
           temp = temp.next;
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

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("The index is invalid. No such element.");
        }

        Node<T> result = head;

        for(int i = 0; i < index; i++){
            result = result.next;
        }

        return result.data;
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
