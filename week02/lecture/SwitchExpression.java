void main() {
    int day = 6;

    String type = switch (day) {
        case 1, 2, 3, 4, 5 -> "working day";
        case 6, 7 -> "weekend";
        default -> "not a day";
    };

    IO.println(type);
}
