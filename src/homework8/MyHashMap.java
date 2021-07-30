package homework8;

import java.util.NoSuchElementException;

public class MyHashMap<K,V> {
    private Pair<K,V>[] map = new Pair[100];
    private int size = 0;

    public boolean put(K key, V value){
        if(map[key.hashCode() % map.length] != null){
            return false;
        } else {
            map[key.hashCode() % map.length] = new Pair<>(key,value);
            size++;
        }
        return true;
    }

    public void clear(){
        map = new Pair[100];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean remove(K key){
        if(map[key.hashCode() % map.length] == null){
            return false;
        } else {
            map[key.hashCode() % map.length] = null;
            size--;
        }
        return true;
    }

    public V get(K key){
        if(map[key.hashCode() % map.length] == null){
            throw new NoSuchElementException("There is no such element in the map");
        } else {
            return map[key.hashCode() % map.length].value;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < map.length; i++){
            if(map[i] != null){
                sb.append("key = " + map[i].key + ", value = " + map[i].value + "|");
            }
        }
        return sb.toString();
    }

    private class Pair<K,V>{
        K key;
        V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
