import java.util.Scanner;

void main() {
    Scanner in =  new Scanner(System.in);

    IO.print("How many numbers? ");
    int count = in.nextInt();

    int[] numbers = new int[count];
    IO.print("Enter " + count + " numbers: ");
    for (int i = 0; i < count; i++) {
        numbers[i] = in.nextInt();
    }

    int smallest = numbers[0];
    int largest = numbers[0];
    int sum = 0;
    for (int number : numbers) {
        if (number < smallest) {
            smallest = number;
        }
        if (number > largest) {
            largest = number;
        }
        sum += number;
    }

    IO.println("Smallest: " + smallest);
    IO.println("Largest: " + largest);
    IO.println("Average: " + (double) sum / count);
}
