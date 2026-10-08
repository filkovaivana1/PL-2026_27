import java.util.Arrays;

void main() {
    // region: show
    int[] points = new int[4];      // four ints, all 0
    points[0] = 12;
    points[3] = 7;

    String[] names = {"Ana", "Marko", "Elena"};

    IO.println(points.length);
    IO.println(Arrays.toString(points));
    IO.println(names[names.length - 1]);
    IO.println(Arrays.toString(new boolean[2]));
    IO.println(Arrays.toString(new String[2]));
    // endregion
}
