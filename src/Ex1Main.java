import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1, num2, base;
        System.out.println();
        System.out.println("Ex1 class solution:");
        System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
        num1 = sc.next();
        if (num1.equals("quit")) {
            System.out.println("quiting now...");

        } else {
            while (!Ex1.isNumber(num1)) {
                System.out.println("num1= " + num1 +" is number: false , value: -1\n" +
                        "ERR: num1 is in the wrong format! (" + num1 + ")");
                num1 = sc.next();
            }
            System.out.println("num1= " + num1 + " is number: true , value: " + Ex1.number2Int(num1) + "\n" +
                    "Enter a string as number#2 (or \"quit\" to end the program): \n");
            num2 = sc.next();
            if (num2.equals("quit")) {
                System.out.println("quiting now...");
                System.exit(0);
            } else {
                while (!Ex1.isNumber(num2)) {
                    System.out.println("num2= " + num2 +" is number: false , value: -1\n" +
                            "ERR: num1 is in the wrong format! (" + num2 + ")");
                    num2 = sc.next();
                }

                System.out.println("num2= " + num2 + " is number: true , value: " + Ex1.number2Int(num2) + "\n" +
                        "Enter a base for output: (a number [2,16])");
            }
            base = sc.next();
            int basis;
            if(Ex1.isBase(base)) {
                if (base.length()>1){
                    basis = Integer.parseInt(base);;
                } else {
                    basis = Ex1.charToInt(base.charAt(0));
                }
                int sum = Ex1.number2Int(num2) + Ex1.number2Int(num1);
                int multi = Ex1.number2Int(num1) * Ex1.number2Int(num2);
                String Sum = Ex1.int2Number(sum, basis);
                String Multi = Ex1.int2Number(multi, basis);
                String[] max = {num1, num2, Sum, Multi};
                System.out.println(num1 + " + " + num2 + " = " + Sum);
                System.out.println(num1 + " * " + num2 + " = " + Multi);
                System.out.println("Max number over [" + num1 + "," + num2 + "," + Sum + "," + Multi + "] is: " + max[(Ex1.maxIndex(max))]);
            }
        }
    }
}

