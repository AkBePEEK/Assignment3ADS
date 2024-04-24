package tasks;

import java.util.Iterator;

public abstract class  MyArrayList<T extends Object & Comparable<T>> implements MyList<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;
    private Object[] List(){
        arr = (T[]) new Object[5];
        size = 0;
        return arr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        if (size >= 0) System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }
    private void shiftingElementsToRight(T cell1, int index){
        for (int i = index + 1; i < arr.length + 1;i++){
            T cell2 = arr[i];
            arr[i++] = cell1;
            cell1 = cell2;
        }
    }
    private void shiftingElementsToLeft(int index){
        for (int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i];
        }
    }

    @Override
    public Object[] toArray() {
        return List();
    }

    @Override
    public boolean exists(Object object) {
        for (T element : arr){
            if (object == element)
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == object)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public void add(T item) {
        if (size >= arr.length)
            increaseBuffer();
        arr[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (size >= arr.length)
            increaseBuffer();
        checkIndex(index);
        T cell1 = arr[index];
        arr[index] = item;
        shiftingElementsToRight(cell1, index);
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        shiftingElementsToLeft(index);
        size--;
    }
    @Override
    public void set(int index, T item) {
        arr[index] = item;
    }

    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    T cell = arr[i];
                    arr[i] = arr[j];
                    arr[j] = cell;
                }
            }
        }
    }
}
