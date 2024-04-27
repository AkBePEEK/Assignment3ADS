package list;

public abstract class  MyArrayList<T extends Object & Comparable<T>> implements MyList<T> {
    private static final int default_size = 5;
    private T[] arr;
    private int size;
    private MyArrayList(){
        this(default_size);
    }

    public MyArrayList(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Illegal ArrayList size: " + size);
        this.arr = createArray(size);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    private void increaseBuffer() {
        T[] newArr = createArray(size * 2);
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
    @SuppressWarnings(value = "unchecked")
    private T[] createArray(int size) {
        return (T[]) new Object[size];
    }

    @Override
    public Object[] toArray() {
        T[] array = createArray(size);
        if (size >= 0) System.arraycopy(arr, 0, array, 0, size);
        return array;
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
        for (int i = 0; i < size; i++)
            arr[i] = null;
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
        boolean swapped;
        for (int i = 0; i < arr.length; i++){
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    T cell = arr[i];
                    arr[i] = arr[j];
                    arr[j] = cell;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
}
