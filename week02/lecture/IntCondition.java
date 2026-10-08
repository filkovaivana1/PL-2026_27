// expect: compile-error
void main() {
    int x = 3;
    if (x = 5) {
        IO.println("five");
    }
}
