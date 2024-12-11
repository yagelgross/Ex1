import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1, num2;
        System.out.println();
        System.out.println("Ex1 class solution:");
        System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
        num1 = sc.nextLine();
        if (num1.equals("quit")) {
            System.out.println("quiting now...");

        } else {
            while (!Ex1.isNumber(num1)) {
                System.out.println("num1= " + num1 + " is number: false , value: -1\n" +
                        "ERR: num1 is in the wrong format! (" + num1 + ")");
                System.out.print("Please enter a number: ");
                num1 = sc.nextLine();
            }

            System.out.println("num1= " + num1 + " is number: true , value: " + Ex1.number2Int(num1) + "\n" +
                    "Enter a string as number#2 (or \"quit\" to end the program): \n");
            num2 = sc.nextLine();
            if (num2.equals("quit")) {
                System.out.println("quiting now...");
                System.exit(0);
            } else {
                while (!Ex1.isNumber(num2)) {
                    System.out.println("num2= " + num2 + " is number: false , value: -1\n" +
                            "ERR: num2 is in the wrong format! (" + num2 + ")");
                    System.out.print("Please enter a number: ");
                    num2 = sc.nextLine();
                }

                System.out.println("num2= " + num2 + " is number: true , value: " + Ex1.number2Int(num2) + "\n" +
                        "Please enter a base for output: (a number [2,16])");
            }
            int base = 0;
            while (base < 2 || base > 16) {
                System.out.print("Enter a base (2 to 16): ");
                if (sc.hasNextInt()) {
                    base = sc.nextInt();
                    if (base < 2 || base > 16) {
                        System.out.println("The base you've entered is incorrect.");
                        System.out.println("Please enter a correct base for output: (a number between 2 and 16).");
                    }
                } else {
                    System.out.println("The input you've entered is incorrect, you need to enter an integer between 2 and 16.");
                    System.out.println("Please enter a correct base for output: (a number between 2 and 16).");
                    sc.next();
                }
            }
            int sum = Ex1.number2Int(num2) + Ex1.number2Int(num1);
            int multi = Ex1.number2Int(num1) * Ex1.number2Int(num2);
            String Sum = Ex1.int2Number(sum, base);
            String Multi = Ex1.int2Number(multi, base);
            String[] max = {num1, num2, Sum, Multi};
            System.out.println(num1 + " + " + num2 + " = " + Sum);
            System.out.println(num1 + " * " + num2 + " = " + Multi);
            System.out.println("Max number over [" + num1 + "," + num2 + "," + Sum + "," + Multi + "] is: " + max[(Ex1.maxIndex(max))]);
        }
    }
}


