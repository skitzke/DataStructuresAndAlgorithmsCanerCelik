import com.algorithms.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the QuickSort class.
 */
public class QuickSortTest {

    /**
     * Tests the sort method of the QuickSort class.
     */
    @Test
    public void testQuickSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        QuickSort.sort(array);
        Integer[] expected = {1, 2, 5, 5, 6, 9};

        assertArrayEquals(expected, array);
    }
}
