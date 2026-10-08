// stdin: 3|8 10 7
import java.util.Scanner;

void main() {
    Scanner in = new Scanner(System.in);

    IO.print("How many grades? ");
    int count = in.nextInt();

    int[] grades = new int[count];
    for (int i = 0; i < count; i++) {
        grades[i] = in.nextInt();
    }

    int sum = 0;
    for (int grade : grades) {
        sum += grade;
    }
    IO.println("Average: " + (double) sum / count);
}
