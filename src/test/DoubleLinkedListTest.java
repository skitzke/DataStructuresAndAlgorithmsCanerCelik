import com.datastructures.DoubleLinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit tests for the DoubleLinkedList class.
 */
public class DoubleLinkedListTest {

    /**
     * Tests the add and get methods of the DoubleLinkedList class.
     */
    @Test
    public void testAddAndGet() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
    }

    /**
     * Tests that the get method throws an IndexOutOfBoundsException for invalid indices.
     */
    @Test
    public void testIndexOutOfBounds() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }
}
