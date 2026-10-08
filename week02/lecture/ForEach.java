void main() {
    int[] grades = {8, 10, 7, 9};

    int sum = 0;
    for (int grade : grades) {
        sum += grade;
    }

    IO.println("Sum: " + sum);
    IO.println("Average: " + (double) sum / grades.length);
}
