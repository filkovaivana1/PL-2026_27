// stdin: 25
void main() {
    String text = IO.readln("Temperature in Celsius: ");
    double celsius = Double.parseDouble(text);
    double fahrenheit = celsius * 9 / 5 + 32;
    IO.println(celsius + " C is " + fahrenheit + " F");
}
