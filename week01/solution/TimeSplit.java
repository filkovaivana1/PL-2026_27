// stdin: 7384
void main() {
    int total = Integer.parseInt(IO.readln("Total seconds: "));

    int hours = total / 3600;
    int minutes = total % 3600 / 60;
    int seconds = total % 60;

    IO.println(hours + " h " + minutes + " min " + seconds + " s");
}
