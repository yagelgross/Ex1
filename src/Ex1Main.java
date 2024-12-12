import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "";
        boolean valid = false;
        System.out.println("Ex1 class solution:");

        while (!valid) {

            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.nextLine();
            if (num1.equals("quit")) {
                System.out.println("quiting now...");
                System.exit(0);
            }

            if (!Ex1.isNumber(num1)) {
                System.out.println("num1= " + num1 + " is number: false , value: -1\n" +
                        "ERR: num1 is in the wrong format! (" + num1 + ")");
                System.out.println("Restarting input for both numbers.");
                continue;
            } else {
                System.out.println("num1= " + num1 + " is number: true , value: " + Ex1.number2Int(num1));
            }

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.nextLine();
            if (num2.equals("quit")) {
                System.out.println("quiting now...");
                System.exit(0);
            }

            if (!Ex1.isNumber(num2)) {
                System.out.println("num2= " + num2 + " is number: false , value: -1\n" +
                        "ERR: num2 is in the wrong format! (" + num2 + ")");
                System.out.println("Restarting input for both numbers.");
            } else {
                System.out.println("num2= " + num2 + " is number: true , value: " + Ex1.number2Int(num2));
                valid = true;
            }
        }

        boolean baseValid = false;
        int base = 0;
        while (!baseValid) {
            System.out.println("Please enter a base for output: (a number [2,16])");
            if (sc.hasNextInt()) {
                base = sc.nextInt();
                if (base < 2 || base > 16) {
                    System.out.println("ERR: The base " + base + " is incorrect. Please enter a base between 2 and 16.");
                    System.out.println("Restarting input for both numbers.\n");
                } else {
                    baseValid = true;
                }
            } else {
                System.out.println("The input you've entered is incorrect. You need to enter an integer between 2 and 16.");
                System.out.println("Please enter a correct base for output: (a number between 2 and 16).\n");
                sc.next(); // Clean invalid input
            }
        }

        int sum = Ex1.number2Int(num1) + Ex1.number2Int(num2);
        int multi = Ex1.number2Int(num1) * Ex1.number2Int(num2);
        String Sum = Ex1.int2Number(sum, base);
        String Multi = Ex1.int2Number(multi, base);
        String[] max = {num1, num2, Sum, Multi};
        System.out.println(num1 + " + " + num2 + " = " + Sum);
        System.out.println(num1 + " * " + num2 + " = " + Multi);
        System.out.println("Max number over [" + num1 + "," + num2 + "," + Sum + "," + Multi + "] is: " + max[Ex1.maxIndex(max)]);

        sc.close();
    }
}
