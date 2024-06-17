import com.datastructures.BinarySearchTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BinarySearchTree class.
 */
public class BinarySearchTreeTest {

    /**
     * Tests the insert and search methods of the BinarySearchTree class.
     */
    @Test
    public void testInsertAndSearch() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
        assertFalse(bst.search(90));
    }
}
