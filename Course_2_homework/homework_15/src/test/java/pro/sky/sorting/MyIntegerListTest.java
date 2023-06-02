package pro.sky.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.sorting.exception.*;

public class MyIntegerListTest {
    private final MyIntegerList myIntegerList = new MyIntegerList();
    private final MyIntegerList arrayWithZeroElements = new MyIntegerList(0);

    @Test
    public void addItemTest() {
        Assertions.assertThat(myIntegerList.add(4))
                .isEqualTo(4)
                .isIn(myIntegerList.toArray());
    }

    @Test
    public void addItemNegativeTest() {
        Assertions.assertThatExceptionOfType(StorageOverflowException.class)
                .isThrownBy(() -> arrayWithZeroElements.add(4))
                .isNotIn(arrayWithZeroElements.toArray());
    }

    @Test
    public void addItemAndIndexTest() {
        myIntegerList.add(3);
        Assertions.assertThat(myIntegerList.add(0, 4))
                .isEqualTo(4)
                .isIn(myIntegerList.toArray());
    }

    @Test
    public void addItemAndIndexNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> myIntegerList.add(-1, 4))
                .isNotIn(myIntegerList.toArray());
    }

    @Test
    public void setTest() {
        myIntegerList.add(5);
        Assertions.assertThat(myIntegerList.set(0, 4))
                .isEqualTo(5);
        Assertions.assertThat(4)
                .isIn(myIntegerList.toArray());
    }

    @Test
    public void setNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> myIntegerList.set(-1, 5))
                .isNotIn(myIntegerList.toArray());
    }

    @Test
    public void removeItemTest() {
        myIntegerList.add(6);
        Assertions.assertThat(myIntegerList.remove((Integer) 6))
                .isEqualTo(6)
                .isNotIn(myIntegerList.toArray());
    }

    @Test
    public void removeItemNegativeTest() {
        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> myIntegerList.remove((Integer) 6))
                .isNotIn(myIntegerList.toArray());
    }

    @Test
    public void removeIndexTest() {
        myIntegerList.add(4);
        Assertions.assertThat(myIntegerList.remove(0))
                .isEqualTo(4)
                .isNotIn(myIntegerList.toArray());
    }

    @Test
    public void removeIndexNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> myIntegerList.remove(-1));
    }

    @Test
    public void containsTest() {
        myIntegerList.add(4);
        Assertions.assertThat(myIntegerList.contains(4))
                .isEqualTo(true);
    }

    @Test
    public void containsFalseTest() {
        Assertions.assertThat(myIntegerList.contains(4))
                .isEqualTo(false);
    }

    @Test
    public void indexOfTest() {
        myIntegerList.add(4);
        Assertions.assertThat(myIntegerList.indexOf(4))
                .isEqualTo(0);
    }

    @Test
    public void indexOfNegativeTest() {
        Assertions.assertThat(myIntegerList.indexOf(4))
                .isEqualTo(-1);
    }

    @Test
    public void lastIndexOfTest() {
        myIntegerList.add(4);
        myIntegerList.add(5);
        Assertions.assertThat(myIntegerList.lastIndexOf(5))
                .isEqualTo(1);
    }

    @Test
    public void lastIndexOfNegativeTest() {
        Assertions.assertThat(myIntegerList.lastIndexOf(4))
                .isEqualTo(-1);
    }

    @Test
    public void getTest() {
        myIntegerList.add(4);
        myIntegerList.add(5);
        Assertions.assertThat(myIntegerList.get(0))
                .isEqualTo(4)
                .isIn(myIntegerList.toArray());
    }

    @Test
    public void getNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> myIntegerList.get(-1));
    }

    @Test
    public void equalsTest() {
        myIntegerList.add(4);
        MyIntegerList myIntegerList1 = new MyIntegerList();
        myIntegerList1.add(4);
        Assertions.assertThat(myIntegerList.equals(myIntegerList1))
                .isEqualTo(true);
    }

    @Test
    public void equalsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> myIntegerList.equals(null));
    }

    @Test
    public void sizeTest() {
        myIntegerList.add(4);
        Assertions.assertThat(myIntegerList.size())
                .isEqualTo(1);
    }

    @Test
    public void isEmptyTest() {
        Assertions.assertThat(myIntegerList.isEmpty())
                .isEqualTo(true);
    }

    @Test
    public void toArrayTest() {
        myIntegerList.add(4);
        MyIntegerList arrayShelf1 = new MyIntegerList();
        arrayShelf1.add(4);
        Assertions.assertThat(myIntegerList.toArray())
                .isEqualTo(arrayShelf1.toArray());
    }

    @Test
    public void toStringTest() {
        myIntegerList.add(4);
        MyIntegerList myIntegerList1 = new MyIntegerList();
        myIntegerList1.add(4);
        Assertions.assertThat(myIntegerList.toString())
                .isEqualTo(myIntegerList1.toString());
    }

    @Test
    public void sort() {
        myIntegerList.add(534);
        myIntegerList.add(3);
        myIntegerList.add(43);
        myIntegerList.add(653);
        MyIntegerList myIntegerList1 = new MyIntegerList();
        myIntegerList1.add(3);
        myIntegerList1.add(43);
        myIntegerList1.add(534);
        myIntegerList1.add(653);

        Assertions.assertThat(myIntegerList.equals(myIntegerList1))
                .isEqualTo(false);

        myIntegerList.sort();

        Assertions.assertThat(myIntegerList.equals(myIntegerList1))
                .isEqualTo(true);
    }
}
