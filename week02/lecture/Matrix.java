void main() {
    // region: show
    int[][] table = new int[3][4];     // 3 rows, 4 columns

    for (int row = 0; row < table.length; row++) {
        for (int col = 0; col < table[row].length; col++) {
            table[row][col] = (row + 1) * (col + 1);
        }
    }

    for (int[] row : table) {
        for (int value : row) {
            IO.print(value + "\t");
        }
        IO.println();
    }
    // endregion
}
