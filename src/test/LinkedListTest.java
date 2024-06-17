import com.datastructures.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the LinkedList class.
 */
public class LinkedListTest {

    /**
     * Tests the add and get methods of the LinkedList class.
     */
    @Test
    public void testAddAndGet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    /**
     * Tests that the get method throws an IndexOutOfBoundsException for invalid indices.
     */
    @Test
    public void testIndexOutOfBounds() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }
}
