/**
 * @author Nastia Kotliar
 * @since 9.4.2026
 *
 * Collect course information and calculate the student's
 * semester GPA using course credits and grades.
 */

import java.util.Scanner;

/**
 * For the SCANNER logic I used parseInt instead of reading nextInt,
 * because I forgot how SCANNER reads numerical values  and leaves "\n" in its buffer.
 * Just a reminder for myself that I can use either SCANNER.nextLine() right after reading,
 * or parse the value I've read.
 */

// Can't wait to learn to wrap it up in struct :)
public class ReviewGPA {
    /**
     * Why static?
     * Yes, I get that non-static field cannot be referred from a static method,
     * But is there only two solutions to it: make it static or create non-static class and create object of it class?
     * Just feels dirty.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String[] HEADERS = {"Class", "Credits", "Grade", "Quality points"};

    private static int numberOfClasses;

    private static String[] names;
    private static int[] credits;
    private static double[] grades;

    private static int totalCredits;
    private static double qualityPoints;

    private static double gpa;

    /**
     * Main method call other methods step by step
     */
    public static void main(String[] args) {
        collectNumberOfClasses();
        collectClassesInformation();
        calculateGPA();
        printResults();
    }

    /**
     * Simply prompts user to enter number of classes she or he is taking this semester
     */
    public static void collectNumberOfClasses() {
        System.out.print("How many classes are you taking this semester? ");
        numberOfClasses = Integer.parseInt(SCANNER.nextLine());
    }

    /**
     * Collects information about all classes
     */
    public static void collectClassesInformation() {
        names = new String[numberOfClasses];
        credits = new int[numberOfClasses];
        grades = new double[numberOfClasses];

        // The loop is prompting user to add information about each class
        // for as many classes as user claim to take
        for (int i = 0; i < numberOfClasses; i++) {
            System.out.print("\nName of the class: ");
            names[i] = SCANNER.nextLine();

            System.out.print("Credits earned: ");
            credits[i] = Integer.parseInt(SCANNER.nextLine());

            System.out.print("Grade: ");
            grades[i] = Double.parseDouble(SCANNER.nextLine());

            // I thought these two brother would be better here,
            // as they are information and I collect information here🤷‍♀️
            totalCredits += credits[i];
            qualityPoints += (credits[i] * grades[i]);
        }
    }

    /**
     * Just calculates GPA. Dunno why it should be a separate method.
     * As per logic - I understand, of course.
     * Just doesn't feel right.
     */
    public static void calculateGPA() {
        gpa = qualityPoints / totalCredits;
    }

    /**
     * This need to let user know how good or bad she or he is.
     */
    public static void printResults() {
        System.out.println();

        // Printing out the headers
        for (String header : HEADERS) {
            System.out.print(header);
            printSpaces(header.length());
        }
        System.out.println();

        // Printing out info about each class
        for (int i = 0; i < credits.length; i++) {
            System.out.print(names[i]);
            printSpaces(names[i].length());

            System.out.print(credits[i]);
            printSpaces(1);

            System.out.printf("%.2f", grades[i]);
            printSpaces(4);

            System.out.printf("%.2f\n", credits[i] * grades[i]);
        }
        System.out.println();

        // Printing out totals
        System.out.println("Total credits: " + totalCredits);
        System.out.printf("Total quality points: %.2f\n", qualityPoints);
        System.out.printf("GPA: %.2f\n", gpa);

        printBonus();
    }

    // Simply prints out spaces so columns look pretty :)
    public static void printSpaces(int itemLength) {
        for (int i = 0; i < 15 - itemLength; i++) {
            System.out.print(" ");
        }
    }

    // Mischief
    public static void printBonus() {
        System.out.println();

        if (gpa >= 3.5) {
            System.out.println("You did great! You even deserved a kitty! Here: 🐈‍⬛");
        } else {
            System.out.println("You did not deserve a kitty yet, but keep working and you'll earn one next time!");
        }
    }
}

/**
 * Here is the sample run:
 *
 * How many classes are you taking this semester? 2
 *
 * Name of the class: me
 * Credits earned: 1
 * Grade: 3.99
 *
 * Name of the class: me
 * Credits earned: 1
 * Grade: 4.0
 *
 * Class          Credits        Grade          Quality points
 * me             1              3.99           3.99
 * me             1              4.00           4.00
 *
 * Total credits: 2
 * Total quality points: 7.99
 * GPA: 4.00
 *
 * You did great! You even deserved a kitty! Here: 🐈‍⬛
 */

// Another run with sample data from the assignment:

/**
 * How many classes are you taking this semester? 5
 *
 * Name of the class: CSC 190
 * Credits earned: 4
 * Grade: 3.33
 *
 * Name of the class: ENG 103
 * Credits earned: 3
 * Grade: 2.67
 *
 * Name of the class: MAT 271
 * Credits earned: 4
 * Grade: 4
 *
 * Name of the class: PE 211
 * Credits earned: 1
 * Grade: 4
 *
 * Name of the class: PHY 251
 * Credits earned: 5
 * Grade: 2.33
 *
 * Class          Credits        Grade          Quality points
 * CSC 190        4              3.33           13.32
 * ENG 103        3              2.67           8.01
 * MAT 271        4              4.00           16.00
 * PE 211         1              4.00           4.00
 * PHY 251        5              2.33           11.65
 *
 * Total credits: 17
 * Total quality points: 52.98
 * GPA: 3.12
 *
 * You did not deserve a kitty yet, but keep working and you'll earn one next time!
 */
