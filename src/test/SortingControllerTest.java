import com.api.SortingController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SortingController class.
 */
public class SortingControllerTest {

    /**
     * Tests the bubble sort method of the SortingController class.
     */
    @Test
    public void testBubbleSort() {
        SortingController sortingController = new SortingController();
        Integer[] array = {5, 2, 9, 1, 5, 6};
        sortingController.bubbleSort(array);
        Integer[] expected = {1, 2, 5, 5, 6, 9};

        assertArrayEquals(expected, array);
    }

    /**
     * Tests the quick sort method of the SortingController class.
     */
    @Test
    public void testQuickSort() {
        SortingController sortingController = new SortingController();
        Integer[] array = {5, 2, 9, 1, 5, 6};
        sortingController.quickSort(array);
        Integer[] expected = {1, 2, 5, 5, 6, 9};

        assertArrayEquals(expected, array);
    }
}
