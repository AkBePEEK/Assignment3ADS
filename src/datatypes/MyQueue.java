package datatypes;

import list.MyList;

public class MyQueue<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        return list.getLast();
    }

    public void enqueue(T t) {
        list.addFirst(t);
    }

    public T dequeue() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }
}
