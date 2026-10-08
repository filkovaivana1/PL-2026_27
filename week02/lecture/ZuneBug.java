// The loop that froze the Zune 30 on 31 December 2008, rewritten in Java
// after the published C code of the clock driver. days counts from 1 January 1980.
// A safety counter is added here, so that this demo ends. The original had none.
boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}

void main() {
    int days = 10593;        // 31 December 2008
    int year = 1980;
    int rounds = 0;

    // region: loop
    while (days > 365) {
        if (isLeapYear(year)) {
            if (days > 366) {
                days -= 366;
                year += 1;
            }
        } else {
            days -= 365;
            year += 1;
        }
        // endregion
        rounds++;
        if (rounds == 1_000_000) {
            IO.println("year = " + year + ", days = " + days);
            IO.println("still looping after " + rounds + " rounds");
            break;
        }
    }
}
