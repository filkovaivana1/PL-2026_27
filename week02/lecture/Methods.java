// region: methods
int max(int a, int b) {
    if (a > b) {
        return a;
    }
    return b;
}

double average(int[] values) {
    int sum = 0;
    for (int value : values) {
        sum += value;
    }
    return (double) sum / values.length;
}
// endregion

// region: main
void main() {
    int[] grades = {8, 10, 7, 9};

    IO.println(max(3, 8));
    IO.println(average(grades));
}
// endregion
