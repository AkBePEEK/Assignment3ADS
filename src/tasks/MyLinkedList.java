package tasks;

import java.util.Iterator;

public class MyLinkedList<E extends Object & Comparable<E>> implements MyList<E>{
    private class Itr implements Iterator<E> {
        MyNode<E> front;

        public Itr() {
            front = head;
        }

        @Override
        public boolean hasNext() {
            return front != null;
        }

        @Override
        public E next() {
            MyNode<E> node = front;
            front = front.next;
            return node.data;
        }
    }
    private static class MyNode<E>{
        E data;
        MyNode<E> next;
        MyNode<E> prev;

        public MyNode(E data) {
            this.data = data;
            next = null;
        }
        public MyNode(E item, MyNode<E> prev, MyNode<E> next){
            this.data = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    private MyNode<E> getNodeAt(int index) {
        checkIndex(index);
        MyNode<E> node = head;
        while (--index != 0 && node.next != null)
            node = node.next;
        return node;
    }

    private MyNode<E> head;
    private MyNode<E> tail;
    int size;
    public MyLinkedList(){
        head = null;
        size = 0;
    }
    @Override
    public void add(E item) {
        size++;
        MyNode<E> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    @Override
    public void set(int index, E item) {
        MyNode<E> node = head;
        while (index-- != 0 && node.next != null){
            node = node.next;
        }
        node.data = item;
    }

    @Override
    public void add(int index, E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if (head == null)
            head = newNode;
        else{
            MyNode<E> currentNode = head;
            while (index-- != 0 && currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.data = item;
            size++;
        }
    }

    @Override
    public void addFirst(E item) {
        add(0, item);
    }

    @Override
    public void addLast(E item) {
        add(item);
    }

    @Override
    public E get(int index) {
        return getNodeAt(index + 1).data;
    }

    @Override
    public E getFirst() {
        return head.data;
    }

    @Override
    public E getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index == 0)
            removeFirst();
        MyNode<E> node = getNodeAt(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        size--;
    }

    @Override
    public void removeLast() {
        tail = tail.prev;
        size--;
    }

    @Override
    public void sort() {
        boolean swapped;
        MyNode<E> node;

        if (head == null)
            return;

        do {
            swapped = false;
            node = head;

            while (node.next != null) {
                if (node.data.compareTo(node.next.data) > 0) {
                    E t = node.next.data;
                    node.next.data = node.data;
                    node.data = t;
                    swapped = true;
                }
                node = node.next;
            }
        } while (swapped);
    }

    @Override
    public int indexOf(Object object) {
        MyNode<E> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(object))
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<E> node = tail;
        int t = -1;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(object))
                t = i;
            node = node.prev;
        }
        return t;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public E[] toArray() {
        return new ;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
}
