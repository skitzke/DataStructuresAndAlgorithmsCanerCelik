import com.algorithms.BubbleSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BubbleSort class.
 */
public class BubbleSortTest {

    /**
     * Tests the sort method of the BubbleSort class.
     */
    @Test
    public void testBubbleSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        BubbleSort.sort(array);
        Integer[] expected = {1, 2, 5, 5, 6, 9};

        assertArrayEquals(expected, array);
    }
}
