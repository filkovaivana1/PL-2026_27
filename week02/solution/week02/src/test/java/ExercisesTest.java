import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// You do not need to change this file. Read it: each test shows what a method must do.
class ExercisesTest {

    @Test
    void task01_isEven() {
        assertTrue(Exercises.isEven(4));
        assertTrue(Exercises.isEven(0));
        assertFalse(Exercises.isEven(7));
        assertTrue(Exercises.isEven(-2));
    }

    @Test
    void task02_max3() {
        assertEquals(9, Exercises.max3(9, 2, 5));
        assertEquals(9, Exercises.max3(2, 9, 5));
        assertEquals(9, Exercises.max3(2, 5, 9));
        assertEquals(4, Exercises.max3(4, 4, 4));
        assertEquals(-1, Exercises.max3(-3, -1, -2));
    }

    @Test
    void task03_dayType() {
        assertEquals("working day", Exercises.dayType(1));
        assertEquals("working day", Exercises.dayType(5));
        assertEquals("weekend", Exercises.dayType(6));
        assertEquals("weekend", Exercises.dayType(7));
        assertEquals("invalid", Exercises.dayType(0));
        assertEquals("invalid", Exercises.dayType(8));
    }

    @Test
    void task04_sumTo() {
        assertEquals(15, Exercises.sumTo(5));
        assertEquals(1, Exercises.sumTo(1));
        assertEquals(5050, Exercises.sumTo(100));
        assertEquals(0, Exercises.sumTo(0));
        assertEquals(0, Exercises.sumTo(-4));
    }

    @Test
    void task05_countDigits() {
        assertEquals(1, Exercises.countDigits(7));
        assertEquals(4, Exercises.countDigits(2026));
        assertEquals(1, Exercises.countDigits(0));
        assertEquals(10, Exercises.countDigits(2147483647));
    }

    @Test
    void task06_sum() {
        assertEquals(34, Exercises.sum(new int[] {8, 10, 7, 9}));
        assertEquals(-5, Exercises.sum(new int[] {-5}));
        assertEquals(0, Exercises.sum(new int[0]));
    }

    @Test
    void task07_max() {
        assertEquals(10, Exercises.max(new int[] {8, 10, 7, 9}));
        assertEquals(3, Exercises.max(new int[] {3}));
        assertEquals(-2, Exercises.max(new int[] {-7, -2, -9}));
    }

    @Test
    void task08_countEvens() {
        assertEquals(2, Exercises.countEvens(new int[] {8, 10, 7, 9}));
        assertEquals(0, Exercises.countEvens(new int[] {1, 3, 5}));
        assertEquals(0, Exercises.countEvens(new int[0]));
    }

    @Test
    void task09_reverse() {
        int[] original = {1, 2, 3, 4};
        int[] result = Exercises.reverse(original);
        assertArrayEquals(new int[] {4, 3, 2, 1}, result);
        assertArrayEquals(new int[] {1, 2, 3, 4}, original, "the original array must not change");
        assertArrayEquals(new int[0], Exercises.reverse(new int[0]));
    }

    @Test
    void task10_isPalindrome() {
        assertTrue(Exercises.isPalindrome("level"));
        assertTrue(Exercises.isPalindrome("abba"));
        assertTrue(Exercises.isPalindrome("a"));
        assertTrue(Exercises.isPalindrome(""));
        assertFalse(Exercises.isPalindrome("Java"));
        assertFalse(Exercises.isPalindrome("ab"));
    }
}
