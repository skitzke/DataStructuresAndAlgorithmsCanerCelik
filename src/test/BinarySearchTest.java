import com.algorithms.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BinarySearch class.
 */
public class BinarySearchTest {

    /**
     * Tests the search method of the BinarySearch class.
     */
    @Test
    public void testBinarySearch() {
        Integer[] array = {1, 2, 5, 5, 6, 9};
        int index = BinarySearch.search(array, 5);
        assertEquals(2, index);

        index = BinarySearch.search(array, 9);
        assertEquals(5, index);

        index = BinarySearch.search(array, 3);
        assertEquals(-1, index);
    }
}
