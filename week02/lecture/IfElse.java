void main() {
    // region: show
    double percent = 72.5;

    if (percent >= 50) {
        IO.println("You passed with " + percent + " percent.");
        IO.println("Congratulations!");
    } else {
        IO.println("Not this time.");
    }

    boolean hasTicket = true;
    if (hasTicket) {              // not: hasTicket == true
        IO.println("See you at the concert.");
    }
    // endregion
}
