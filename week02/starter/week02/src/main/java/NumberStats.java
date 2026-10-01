// Task 11. A small program with keyboard input.
// Read how many numbers follow, read them into an array,
// then print the smallest, the largest and the average.
//
// Expected console session:
//   How many numbers? 4
//   Enter 4 numbers: 8 10 7 9
//   Smallest: 7
//   Largest: 10
//   Average: 8.5
//
// Scanner is the classic way to read input. You will see it in many books.
import java.util.Scanner;

void main() {
    Scanner in = new Scanner(System.in);

    IO.print("How many numbers? ");
    int count = in.nextInt();

    // TODO 1: create an int array of that length
    // TODO 2: print "Enter <count> numbers: " and read each number with in.nextInt()
    // TODO 3: find the smallest and the largest value with one loop
    // TODO 4: print smallest, largest and average as in the example
}
