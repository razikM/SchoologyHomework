package homework8;

public class MyArrayList<T> {
    private T[] data;

    public MyArrayList(){
        data = (T[]) new Object[0];
    }

    public boolean add(T value){
        try {
            T[] result = (T[]) new Object[data.length + 1];
            System.arraycopy(data,0,result,0, data.length);
            data = result;
            data[data.length - 1] = value;
            return true;
        } catch (ClassCastException ex){
            System.err.println("The element was not added to the array");
        }
        return false;
    }

    public boolean remove(int index){
        if(index < 0 || index >= data.length){
            return false;
        }

        try {
            T[] result = (T[]) new Object[data.length - 1];
            System.arraycopy(data,0,result,0, index);
            System.arraycopy(data,index + 1,result,index, data.length - index - 1);
            data = result;
            return true;
        } catch (ClassCastException ex){
            System.err.println("The element was not deleted from the array");
        }

        return false;
    }

    public void clear(){
        data =  (T[]) new Object[0];
    }

    public int size(){
        return data.length;
    }

    public T get(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("The index is invalid. No element on such index.");
        }

        return data[index];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < size(); i++){
            sb.append(data[i].toString());
            if(i < size() - 1){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
