import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Tests for the two stretch tasks. They are not required.
class StretchTest {

    @Test
    void stretchA_secondLargest() {
        assertEquals(7, Exercises.secondLargest(new int[] {4, 9, 9, 7}));
        assertEquals(1, Exercises.secondLargest(new int[] {1, 2}));
        assertEquals(-5, Exercises.secondLargest(new int[] {-5, -1, -9}));
    }

    @Test
    void stretchB_pascal() {
        int[][] rows = Exercises.pascal(5);
        assertEquals(5, rows.length);
        assertArrayEquals(new int[] {1}, rows[0]);
        assertArrayEquals(new int[] {1, 1}, rows[1]);
        assertArrayEquals(new int[] {1, 2, 1}, rows[2]);
        assertArrayEquals(new int[] {1, 3, 3, 1}, rows[3]);
        assertArrayEquals(new int[] {1, 4, 6, 4, 1}, rows[4]);
        assertEquals(0, Exercises.pascal(0).length);
    }
}
