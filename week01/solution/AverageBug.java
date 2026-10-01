void main() {
    int first = 8;
    int second = 9;
    int third = 9;

    int sum = first + second + third;
    double average = sum / 3.0;   // one side must be a double, or the decimals are cut off

    IO.println("Average: " + average);
}
