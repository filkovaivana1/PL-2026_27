// expect: exception
void main() {
    int x = 0;

    boolean safe = x != 0 && 10 / x > 1;
    IO.println(safe);

    boolean risky = x != 0 & 10 / x > 1;
    IO.println(risky);
}
