import java.util.Arrays;

void main() {
    // region: show
    String[][] seats = {
        {"Ana", "Marko", "Elena"},
        {"Ivan", "Sara"},
        {"Petar"}
    };

    for (String[] row : seats) {
        IO.println(row.length + ": " + Arrays.toString(row));
    }
    // endregion
}
