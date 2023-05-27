package pro.sky.StringList;

import pro.sky.StringList.exception.*;

import java.util.Arrays;
import java.util.Objects;

public class ArrayShelf implements StringList {
    private transient String[] storage;
    private int customCapacity = 0;
    private final int CAPACITY_INIT = 10;
    private int size = 0;


    public ArrayShelf(int capacity) {
        if (capacity > 0) {
            this.storage = new String[capacity];
            customCapacity = capacity;
        } else if (capacity == 0) {
            this.storage = new String[0];
        } else {
            throw new IncorrectValueException("Negative numbers are under limitation");
        }
    }

    public ArrayShelf() {
        this.storage = new String[CAPACITY_INIT];
    }

    @Override
    public String add(String item) {
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
    public String add(int index, String item) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        storage[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        String oldItem = storage[index];
        storage[index] = item;
        return oldItem;
    }

    @Override
    public String remove(String item) {
        int checker = -1;
        for (int i = 0; i < storage.length; i++) {
            if (Objects.equals(storage[i], item)) {
                checker = i;
                break;
            }
        }
        String removeItem;
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
    public String remove(int index) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        String removeItem = storage[index];
        for (int i = index; i < storage.length - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage = Arrays.copyOf(storage, storage.length - 1);
        return removeItem;
    }

    @Override
    public boolean contains(String item) {
        for (String s : storage) {
            if (Objects.equals(s, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < storage.length; i++) {
            if (Objects.equals(storage[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = storage.length - 1; i >= 0; i--) {
            if (Objects.equals(storage[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > storage.length) {
            throw new IncorrectValueException("Unsupported index of array");
        }
        return this.storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        storage = new String[CAPACITY_INIT];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(storage, size));
    }
}
