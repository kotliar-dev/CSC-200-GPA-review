import java.util.Scanner;

/**
 * For the scanner logic I used parseInt instead of reading nextInt,
 * because I forgot how scanner reads numerical values  and leaves "\n" in its buffer.
 * Just a reminder for myself that I can use either scanner.nextLine() right after reading,
 * or parse the value I've read.
 */
public class ReviewGPAClass {

    // Final - because it only refers to this scanner object. But why static?
    // Yes, I get that non-static field cannot be refered from a static method,
    // But is there only two solutions to it: make it static or create non-static class and create object of it class?
    // Just feels dirty.
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("How many classes you're taking this semester? ");
        int numberOfClasses = Integer.parseInt(scanner.nextLine());

        String[] names = new String[numberOfClasses];
        int[] credits = new int[numberOfClasses];
        double[] grades = new double[numberOfClasses];

        int totalCredits = 0;
        double qualityPoints = 0.0;

        for (int i = 0; i < numberOfClasses; i++) {
            System.out.print("Name of the class: ");
            names[i] = scanner.nextLine();

            System.out.print("Credits earned: ");
            credits[i] = Integer.parseInt(scanner.nextLine());

            System.out.print("Grade: ");
            grades[i] = Double.parseDouble(scanner.nextLine());

            totalCredits += credits[i];

            qualityPoints += (credits[i] * grades[i]);
        }

        System.out.printf("Your GPA is %.2f\n", qualityPoints / totalCredits);
    }
}
