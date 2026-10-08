void main() {
    int i = 100;
    while (i < 100) {
        IO.println("while: " + i);
        i = i + 10;
    }

    int k = 100;
    do {
        IO.println("do while: " + k);
        k = k + 10;
    } while (k < 100);
}
