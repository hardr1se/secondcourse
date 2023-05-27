package pro.sky.IntegerList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.IntegerList.exception.IncorrectValueException;
import pro.sky.IntegerList.exception.NotFoundElementException;
import pro.sky.IntegerList.exception.StorageOverflowException;

public class IntegerShelfTest {
    private final IntegerShelf integerShelf = new IntegerShelf();
    private final IntegerShelf arrayWithZeroElements = new IntegerShelf(0);

    @Test
    public void addItemTest() {
        Assertions.assertThat(integerShelf.add(4))
                .isEqualTo(4)
                .isIn(integerShelf.toArray());
    }

    @Test
    public void addItemNegativeTest() {
        Assertions.assertThatExceptionOfType(StorageOverflowException.class)
                .isThrownBy(() -> arrayWithZeroElements.add(4))
                .isNotIn(arrayWithZeroElements.toArray());
    }

    @Test
    public void addItemAndIndexTest() {
        integerShelf.add(3);
        Assertions.assertThat(integerShelf.add(0, 4))
                .isEqualTo(4)
                .isIn(integerShelf.toArray());
    }

    @Test
    public void addItemAndIndexNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> integerShelf.add(-1, 4))
                .isNotIn(integerShelf.toArray());
    }

    @Test
    public void setTest() {
        integerShelf.add(5);
        Assertions.assertThat(integerShelf.set(0, 4))
                .isEqualTo(5);
        Assertions.assertThat(4)
                .isIn(integerShelf.toArray());
    }

    @Test
    public void setNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> integerShelf.set(-1, 5))
                .isNotIn(integerShelf.toArray());
    }

    @Test
    public void removeItemTest() {
        integerShelf.add(6);
        Assertions.assertThat(integerShelf.remove((Integer) 6))
                .isEqualTo(6)
                .isNotIn(integerShelf.toArray());
    }

    @Test
    public void removeItemNegativeTest() {
        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> integerShelf.remove((Integer) 6))
                .isNotIn(integerShelf.toArray());
    }

    @Test
    public void removeIndexTest() {
        integerShelf.add(4);
        Assertions.assertThat(integerShelf.remove(0))
                .isEqualTo(4)
                .isNotIn(integerShelf.toArray());
    }

    @Test
    public void removeIndexNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> integerShelf.remove(-1));
    }

    @Test
    public void containsTest() {
        integerShelf.add(4);
        Assertions.assertThat(integerShelf.contains(4))
                .isEqualTo(true);
    }

    @Test
    public void containsFalseTest() {
        Assertions.assertThat(integerShelf.contains(4))
                .isEqualTo(false);
    }

    @Test
    public void indexOfTest() {
        integerShelf.add(4);
        Assertions.assertThat(integerShelf.indexOf(4))
                .isEqualTo(0);
    }

    @Test
    public void indexOfNegativeTest() {
        Assertions.assertThat(integerShelf.indexOf(4))
                .isEqualTo(-1);
    }

    @Test
    public void lastIndexOfTest() {
        integerShelf.add(4);
        integerShelf.add(5);
        Assertions.assertThat(integerShelf.lastIndexOf(5))
                .isEqualTo(1);
    }

    @Test
    public void lastIndexOfNegativeTest() {
        Assertions.assertThat(integerShelf.lastIndexOf(4))
                .isEqualTo(-1);
    }

    @Test
    public void getTest() {
        integerShelf.add(4);
        integerShelf.add(5);
        Assertions.assertThat(integerShelf.get(0))
                .isEqualTo(4)
                .isIn(integerShelf.toArray());
    }

    @Test
    public void getNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> integerShelf.get(-1));
    }

    @Test
    public void equalsTest() {
        integerShelf.add(4);
        IntegerShelf integerShelf1 = new IntegerShelf();
        integerShelf1.add(4);
        Assertions.assertThat(integerShelf.equals(integerShelf1))
                .isEqualTo(true);
    }

    @Test
    public void equalsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> integerShelf.equals(null));
    }

    @Test
    public void sizeTest() {
        integerShelf.add(4);
        Assertions.assertThat(integerShelf.size())
                .isEqualTo(1);
    }

    @Test
    public void isEmptyTest() {
        Assertions.assertThat(integerShelf.isEmpty())
                .isEqualTo(true);
    }

    @Test
    public void toArrayTest() {
        integerShelf.add(4);
        IntegerShelf arrayShelf1 = new IntegerShelf();
        arrayShelf1.add(4);
        Assertions.assertThat(integerShelf.toArray())
                .isEqualTo(arrayShelf1.toArray());
    }

    @Test
    public void toStringTest() {
        integerShelf.add(4);
        IntegerShelf integerShelf1 = new IntegerShelf();
        integerShelf1.add(4);
        Assertions.assertThat(integerShelf.toString())
                .isEqualTo(integerShelf1.toString());
    }

    @Test
    public void sort() {
        integerShelf.add(534);
        integerShelf.add(3);
        integerShelf.add(43);
        integerShelf.add(653);
        IntegerShelf integerShelf1 = new IntegerShelf();
        integerShelf1.add(3);
        integerShelf1.add(43);
        integerShelf1.add(534);
        integerShelf1.add(653);

        Assertions.assertThat(integerShelf.equals(integerShelf1))
                .isEqualTo(false);

        integerShelf.sort();

        Assertions.assertThat(integerShelf.equals(integerShelf1))
                .isEqualTo(true);
    }
}
