import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        System.out.println();
        System.out.println("Ex1 class solution:");
        System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
        num1 = sc.next();
        if (num1.equals("quit")) {
            System.out.println("quiting now...");
            System.exit(1);
        }
        if (Ex1.isNumber(num1)) {
            int i = Ex1.number2Int(num1);
            System.out.println("num1 = " + num1 + " is number: true , value: " + i);
        } else if (!Ex1.isNumber(num1)) {
            System.out.println("num1 = " + num1 + " is number: false , value: -1");
        }
    }
}
