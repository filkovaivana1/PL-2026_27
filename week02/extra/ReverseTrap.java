import java.util.Arrays;

// Shown in the lab deck: a reverse method that works on the array of the caller.
// region: bad
int[] reverse(int[] values) {
    for (int i = 0; i < values.length / 2; i++) {
        int other = values.length - 1 - i;
        int keep = values[i];
        values[i] = values[other];
        values[other] = keep;
    }
    return values;
}
// endregion

// region: main
void main() {
    int[] original = {1, 2, 3, 4};
    int[] result = reverse(original);
    IO.println("result:   " + Arrays.toString(result));
    IO.println("original: " + Arrays.toString(original));
}
// endregion
