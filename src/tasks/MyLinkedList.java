package tasks;

import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>{
    private class MyNode<E>{
        E data;
        MyNode<E> next;

        public MyNode(E data) {
            this.data = data;
            next = null;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    private MyNode<E> head;
    private MyNode<E> tail;
    int size;
    public MyLinkedList(){
        head = null;
        size = 0;
    }
    @Override
    public void add(Object item) {
        MyNode<E> newNode = (MyNode<E>) new MyNode<>(item);
        if (head == null) {
            head = newNode;
        }
        else {
            MyNode<E> currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, Object item) {

    }

    @Override
    public void add(int index, Object item) {
        checkIndex(index);
        MyNode<E> currentNode = head;
        if (index == 0)
            return currentNode.data;
        else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        }
        return currentNode.data;
    }

    @Override
    public void addFirst(Object item) {

    }

    @Override
    public void addLast(Object item) {

    }

    @Override
    public Object get(int index) {
        return arr[index];
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
