package datatypes;

import list.MyList;

public class MyMinHeap<T extends Comparable<T>> {
    private final MyList<T> list;

    public MyMinHeap(MyList<T> list) {
        list.add(null);
        this.list = list;
    }

    public boolean empty() {
        return size() == 1;
    }

    public int size() {
        return list.size() - 1;
    }

    public T getMin() {
        return list.get(1);
    }

    public T extractMin() {
        T min = getMin();
        list.set(1, list.getLast());
        list.removeLast();
        heapify(1);
        return min;
    }

    public void insert(T t) {
        list.addLast(t);
        traverseUp(t, list.size() - 1);
    }

    private void heapify(int index) {
        int l = leftChildOf(index);
        int r = rightChildOf(index);
        int go;
        if (l >= size() || r >= size())
            return;
        if (l >= size())
            go = r;
        else if (r >= size())
            go = l;
        else
            go = list.get(l).compareTo(list.get(r)) > 0 ? r : l;

        if (list.get(index).compareTo(list.get(go)) > 0) {
            swap(index, go);
            heapify(go);
        }
    }

    private void traverseUp(T t, int index) {
        int parent = parentOf(index);
        if (list.get(parent).compareTo(t) > 0) {
            swap(parent, index);
            traverseUp(t, parent);
        }
    }

    private int leftChildOf(int index) {
        return index * 2 - 1;
    }

    private int rightChildOf(int index) {
        return index * 2;
    }

    private int parentOf(int index) {
        if (index == 1)
            return 1;
        return index / 2;
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

}
