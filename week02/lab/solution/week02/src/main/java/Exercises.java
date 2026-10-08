// Week 2 lab, reference solution.
public class Exercises {

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public static String dayType(int day) {
        return switch (day) {
            case 1, 2, 3, 4, 5 -> "working day";
            case 6, 7 -> "weekend";
            default -> "invalid";
        };
    }

    public static int sumTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int countDigits(int n) {
        int digits = 1;
        while (n >= 10) {
            n = n / 10;
            digits++;
        }
        return digits;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int countEvens(int[] values) {
        int count = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] reverse(int[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[values.length - 1 - i] = values[i];
        }
        return result;
    }

    public static boolean isPalindrome(String text) {
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int secondLargest(int[] values) {
        int largest = max(values);
        boolean found = false;
        int second = 0;
        for (int value : values) {
            if (value < largest && (!found || value > second)) {
                second = value;
                found = true;
            }
        }
        return second;
    }

    public static int[][] pascal(int n) {
        int[][] rows = new int[n][];
        for (int row = 0; row < n; row++) {
            rows[row] = new int[row + 1];
            rows[row][0] = 1;
            rows[row][row] = 1;
            for (int col = 1; col < row; col++) {
                rows[row][col] = rows[row - 1][col - 1] + rows[row - 1][col];
            }
        }
        return rows;
    }
}
