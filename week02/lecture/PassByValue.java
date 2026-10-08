void addTen(int number) {
    number = number + 10;
}

void addTenToFirst(int[] numbers) {
    numbers[0] = numbers[0] + 10;
}

void main() {
    int n = 1;
    int[] arr = {1, 2, 3};

    addTen(n);
    addTenToFirst(arr);
    IO.println(n);
    IO.println(arr[0]);
}
