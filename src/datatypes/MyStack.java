package datatypes;

import list.MyList;

public class MyStack<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyStack(MyList<T> list) {
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

    public void push(T t) {
        list.addLast(t);
    }

    public T pop() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }
}
