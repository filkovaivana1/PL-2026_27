void main() {
    int x = 5;
    int y = x;
    y = 99;

    int[] a = {1, 2, 3};
    int[] b = a;
    b[0] = 99;

    IO.println(x);
    IO.println(a[0]);
}
