package pro.sky.IntegerList;

import pro.sky.IntegerList.exception.*;

import java.util.Arrays;
import java.util.Objects;

public class IntegerShelf implements IntegerList {
    private transient Integer[] storage;
    private int customCapacity = 0;
    private final int CAPACITY_INIT = 10;
    private int size = 0;


    public IntegerShelf(int capacity) {
        if (capacity > 0) {
            this.storage = new Integer[capacity];
            customCapacity = capacity;
        } else if (capacity == 0) {
            this.storage = new Integer[0];
        } else {
            throw new IncorrectValueException("Negative numbers are under limitation");
        }
    }

    public IntegerShelf() {
        this.storage = new Integer[CAPACITY_INIT];
    }

    @Override
    public Integer add(Integer item) {
        if (storage.length == 0) {
            throw new StorageOverflowException();
        }
        if (size > storage.length) {
            if (customCapacity != 0) {
                storage = Arrays.copyOf(storage, storage.length + 1);
            } else {
                throw new StorageOverflowException();
            }
        }
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        storage[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        Integer oldItem = storage[index];
        storage[index] = item;
        return oldItem;
    }

    @Override
    public Integer remove(Integer item) {
        int checker = -1;
        for (int i = 0; i < storage.length; i++) {
            if (Objects.equals(storage[i], item)) {
                checker = i;
                break;
            }
        }
        Integer removeItem;
        if (checker != -1) {
            removeItem = storage[checker];
            for (int i = checker; i < storage.length - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage = Arrays.copyOf(storage, storage.length - 1);
        } else {
            throw new NotFoundElementException("Element wasn't found");
        }
        return removeItem;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        Integer removeItem = storage[index];
        for (int i = index; i < storage.length - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage = Arrays.copyOf(storage, storage.length - 1);
        return removeItem;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < storage.length; i++) {
            if (Objects.equals(storage[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = storage.length - 1; i >= 0; i--) {
            if (Objects.equals(storage[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        return this.storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IncorrectValueException("Null values are under limitation");
        }
        for (int i = 0; i < otherList.size(); i++) {
            if (!Objects.equals(storage[i], otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        storage = new Integer[CAPACITY_INIT];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(storage, size));
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] array = Arrays.copyOf(storage, size);
        quickSort(array, 0, array.length - 1);
        return binarySearch(array, item);
    }

    public void sort() {
        quickSort(storage, 0, size - 1); //TODO 18 nanosec per 100_000 elements
        //Arrays.sort(storage); TODO 89 nanosec per 100_000 elements
        //sortWithLotOfLoops(storage); TODO 16370 nanosec per 100_000 elements
        //bubbleSort(sortArray); TODO 29755 nanosec per 100_000 elements
    }

    private boolean binarySearch(Integer[] array, Integer num) {
        return Arrays.binarySearch(array, num) >= 0;
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(Integer[] array, int p, int r) {
        final int x = array[(p + r) >>> 1];
        int i = p - 1; int j = r + 1;

        while (true) {
            while (x < array[--j]);
            while (x > array[++i]);
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            else {
                return j;
            }
        }
    }

    private void sortWithLotOfLoops(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if( array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
