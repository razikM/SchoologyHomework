package homework8;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        MyQueue<Character> queue = new MyQueue<>();
        MyStack<Double> stack = new MyStack<>();
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();

        // test add() and size()
        for(int i = 0; i < 25; i++){
            arrayList.add(i);
            linkedList.add(i + "s");
            queue.add((char) (i + 65));
            stack.add((double)i);
            hashMap.put(i,"hash" + i);
        }

        System.out.print(arrayList + " size is " + arrayList.size() + "\n");
        System.out.print(linkedList + " size is " + linkedList.size() + "\n");
        System.out.print(queue + " size is " + queue.size() + "\n");
        System.out.print(stack + " size is " + stack.size() + "\n");
        System.out.print(hashMap + " size is " + hashMap.size() + "\n");

        // test get
        for(int i = 0; i < 25; i++){
            System.out.println(arrayList.get(i));
            System.out.println(linkedList.get(i));
            System.out.println(queue.get(i));
            System.out.println(stack.get(i));
            System.out.println(hashMap.get(i));
            System.out.println("---");
        }

        // test remove
        arrayList.remove(0);
        arrayList.remove(arrayList.size() - 1);

        linkedList.remove(0);
        linkedList.remove(linkedList.size() - 1);

        queue.remove(0);
        queue.remove(queue.size() - 1);

        stack.remove(0);
        stack.remove(stack.size() - 1);

        hashMap.remove(0);
        hashMap.remove(hashMap.size() - 1);

        System.out.print(arrayList + " size is " + arrayList.size() + "\n");
        System.out.print(linkedList + " size is " + linkedList.size() + "\n");
        System.out.print(queue + " size is " + queue.size() + "\n");
        System.out.print(stack + " size is " + stack.size() + "\n");
        System.out.print(hashMap + " size is " + hashMap.size() + "\n");

        // test poll and pop
        System.out.println(queue.poll());
        System.out.println(stack.pop());

        System.out.print(queue + " size is " + queue.size() + "\n");
        System.out.print(stack + " size is " + stack.size() + "\n");

        // test clear
        arrayList.clear();
        linkedList.clear();
        queue.clear();
        stack.clear();
        hashMap.clear();

        System.out.print(arrayList + " size is " + arrayList.size() + "\n");
        System.out.print(linkedList + " size is " + linkedList.size() + "\n");
        System.out.print(queue + " size is " + queue.size() + "\n");
        System.out.print(stack + " size is " + stack.size() + "\n");
        System.out.print(hashMap + " size is " + hashMap.size() + "\n");
    }
}
