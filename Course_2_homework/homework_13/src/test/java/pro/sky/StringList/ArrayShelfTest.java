package pro.sky.StringList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.StringList.exception.IncorrectValueException;
import pro.sky.StringList.exception.NotFoundElementException;
import pro.sky.StringList.exception.StorageOverflowException;

public class ArrayShelfTest {
    private final ArrayShelf arrayShelf = new ArrayShelf();
    private final ArrayShelf arrayWithZeroElements = new ArrayShelf(0);

    @Test
    public void addItemTest() {
        arrayShelf.add("Test");
        Assertions.assertThat(arrayShelf.add("Test"))
                .isEqualTo("Test")
                .isIn(arrayShelf.toArray());
    }

    @Test
    public void addItemNegativeTest() {
        Assertions.assertThatExceptionOfType(StorageOverflowException.class)
                .isThrownBy(() -> arrayWithZeroElements.add("Test"))
                .isNotIn(arrayWithZeroElements.toArray());
    }

    @Test
    public void addItemAndIndexTest() {
        arrayShelf.add("Test");
        Assertions.assertThat(arrayShelf.add(0, "Testy"))
                .isEqualTo("Testy")
                .isIn(arrayShelf.toArray());
    }

    @Test
    public void addItemAndIndexNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> arrayShelf.add(-1, "Test"))
                .isNotIn(arrayShelf.toArray());
    }

    @Test
    public void setTest() {
        arrayShelf.add("Test");
        Assertions.assertThat(arrayShelf.set(0, "Testy"))
                .isEqualTo("Test");
        Assertions.assertThat("Testy")
                .isIn(arrayShelf.toArray());
    }

    @Test
    public void setNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> arrayShelf.set(-1, "Test"))
                .isNotIn(arrayShelf.toArray());
    }

    @Test
    public void removeItemTest() {
        arrayShelf.add("Test");
        Assertions.assertThat(arrayShelf.remove("Test"))
                .isEqualTo("Test")
                .isNotIn(arrayShelf.toArray());
    }

    @Test
    public void removeItemNegativeTest() {
        Assertions.assertThatExceptionOfType(NotFoundElementException.class)
                .isThrownBy(() -> arrayShelf.remove("Test"))
                .isNotIn(arrayShelf.toArray());
    }

    @Test
    public void removeIndexTest() {
        arrayShelf.add("Test");
        Assertions.assertThat(arrayShelf.remove(0))
                .isEqualTo("Test")
                .isNotIn(arrayShelf.toArray());
    }

    @Test
    public void removeIndexNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> arrayShelf.remove(-1));
    }

    @Test
    public void containsTest() {
        arrayShelf.add("Test");
        Assertions.assertThat(arrayShelf.contains("Test"))
                .isEqualTo(true);
    }

    @Test
    public void containsFalseTest() {
        Assertions.assertThat(arrayShelf.contains("Test"))
                .isEqualTo(false);
    }

    @Test
    public void indexOfTest() {
        arrayShelf.add("Test");
        Assertions.assertThat(arrayShelf.indexOf("Test"))
                .isEqualTo(0);
    }

    @Test
    public void indexOfNegativeTest() {
        Assertions.assertThat(arrayShelf.indexOf("Test"))
                .isEqualTo(-1);
    }

    @Test
    public void lastIndexOfTest() {
        arrayShelf.add("Test1");
        arrayShelf.add("Test2");
        Assertions.assertThat(arrayShelf.lastIndexOf("Test2"))
                .isEqualTo(1);
    }

    @Test
    public void lastIndexOfNegativeTest() {
        Assertions.assertThat(arrayShelf.lastIndexOf("Test"))
                .isEqualTo(-1);
    }

    @Test
    public void getTest() {
        arrayShelf.add("Test1");
        arrayShelf.add("Test2");
        Assertions.assertThat(arrayShelf.get(0))
                .isEqualTo("Test1")
                .isIn(arrayShelf.toArray());
    }

    @Test
    public void getNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> arrayShelf.get(-1));
    }

    @Test
    public void equalsTest() {
        arrayShelf.add("Test2");
        ArrayShelf arrayShelf1 = new ArrayShelf();
        arrayShelf1.add("Test2");
        Assertions.assertThat(arrayShelf.equals(arrayShelf1))
                .isEqualTo(true);
    }

    @Test
    public void equalsNegativeTest() {
        Assertions.assertThatExceptionOfType(IncorrectValueException.class)
                .isThrownBy(() -> arrayShelf.equals(null));
    }

    @Test
    public void sizeTest() {
        arrayShelf.add("Test2");
        Assertions.assertThat(arrayShelf.size())
                .isEqualTo(1);
    }

    @Test
    public void isEmptyTest() {
        Assertions.assertThat(arrayShelf.isEmpty())
                .isEqualTo(true);
    }

    @Test
    public void toArrayTest() {
        arrayShelf.add("Test2");
        ArrayShelf arrayShelf1 = new ArrayShelf();
        arrayShelf1.add("Test2");
        Assertions.assertThat(arrayShelf.toArray())
                .isEqualTo(arrayShelf1.toArray());
    }

    @Test
    public void toStringTest() {
        arrayShelf.add("Test2");
        ArrayShelf arrayShelf1 = new ArrayShelf();
        arrayShelf1.add("Test2");
        Assertions.assertThat(arrayShelf.toString())
                .isEqualTo(arrayShelf1.toString());
    }
}
