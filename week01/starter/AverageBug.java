// Task 5. This program runs, and the result is wrong.
// The average of 8, 9 and 9 should be 8.67 (rounded), not 8.0.
// Do not guess. Use the debugger:
//   1. set a breakpoint on the line that calculates the average
//   2. start the program with Debug
//   3. look at the values of sum and average in the Variables view
//   4. step over the line and watch what happens
// Then fix the bug and commit the fix with a good message.
void main() {
    int first = 8;
    int second = 9;
    int third = 9;

    int sum = first + second + third;
    double average = sum / 3;

    IO.println("Average: " + average);
}
