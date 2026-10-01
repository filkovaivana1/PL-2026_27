// stdin: 1786
void main() {
    int amount = Integer.parseInt(IO.readln("Amount: "));

    IO.println("500 x " + amount / 500);
    amount = amount % 500;
    IO.println("100 x " + amount / 100);
    amount = amount % 100;
    IO.println("50 x " + amount / 50);
    amount = amount % 50;
    IO.println("10 x " + amount / 10);
    amount = amount % 10;
    IO.println("5 x " + amount / 5);
    amount = amount % 5;
    IO.println("1 x " + amount);
}
