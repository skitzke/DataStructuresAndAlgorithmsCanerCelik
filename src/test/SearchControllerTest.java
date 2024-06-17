import com.api.SearchController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the SearchController class.
 */
public class SearchControllerTest {

    /**
     * Tests the binary search method of the SearchController class.
     */
    @Test
    public void testBinarySearch() {
        SearchController searchController = new SearchController();
        Integer[] array = {1, 2, 5, 5, 6, 9};
        int index = searchController.binarySearch(array, 5);
        assertEquals(2, index);

        index = searchController.binarySearch(array, 9);
        assertEquals(5, index);

        index = searchController.binarySearch(array, 3);
        assertEquals(-1, index);
    }
}
