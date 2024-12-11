/**
 * This class represents a simple solution for Ex1.
 * As defined here: <a href="https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit">...</a>
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”, ”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    public static char intToChar(int num) {
        char ch = '0', newCh;
        if (num >= 0 && num <= 9) {
            newCh = (char) ('0' + num);
        } else {
            newCh = (char) ('A' + (num - 10));
        }
        ch = newCh;
        return ch;
    }

    public static int charToInt(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'G') {
            return c - 'A' + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        return -1;
    }


    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return string
     */
    public static int number2Int(String num) {
        int base = 10;
        String numPart = num;
        if (num.contains("b")) {
            String[] parts = num.split("b");
            int basis = charToInt(parts[1].charAt(0));
            if (parts.length != 2) {
                return -1;
            }
            base = charToInt(parts[1].charAt(0));
            numPart = parts[0];
        }
        if (base < 2 || base > 16) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < numPart.length(); i++) {
            char c = numPart.charAt(i);
            int value = charToInt(c);
            if (value == -1 || value >= base) {
                return -1;
            }
            result = result * base + value;
        }
        return result;
    }

    public static boolean isNumInBase(String num, int base) {
        String validChars = "0123456789ABCDEFG".substring(0, base);  // Get all valid characters for the base
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (validChars.indexOf(c) == -1) {
                return false;  // Invalid character for the base
            }
        }
        return true;
    }


    public static boolean isBase(String base) {
        if (base == null || base.isEmpty()) {
            return false;
        }
        try {

            int b = charToInt(base.charAt(0));
            return b >= 2 && b <= 16;
        } catch (NumberFormatException e) {
            return false;  // If base is not a valid number
        }
    }


    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {

        if (a == null || a.isEmpty()) { // Check if the string contains 'b' to determine if it's a base-specific number
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == ' ') {
                return false;
        }

        }

        if (!a.contains("b")) {  // If there is no 'b', it's a base 10 number

            for (int i = 0; i < a.length(); i++) { // Check if the string consists only of digits
                char c = a.charAt(i);
                if (c < '0' || c > '9') {
                    return false;  // Not a valid number if it contains non-digit characters
                }
            }
            return true;  // Valid decimal number
        } else {

            String[] parts = a.split("b");  // Split the string by 'b' into number part and base part
            if (parts.length != 2) {
                return false;  // Invalid format if there is more than one 'b'
            }

            String numPart = parts[0];  // Number part
            String basePart = parts[1]; // Base part

            if (!isBase(basePart)) {  // Validate the base: it must be a valid integer between 2 and 16
                System.out.println("7878");
                return false;
            }

            // Now validate the number part: it must be a valid number in the specified base
            int base = charToInt(basePart.charAt(0));
            return isNumInBase(numPart, base);  // Check if the number part is valid in the given base
        }
    }



    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */


    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int currentNum = num;
        while (currentNum > 0) {
            int remainder = currentNum % base;
            if (remainder < 10) {
                result.append((char) ('0' + remainder));
            } else {

                result.append((char) ('A' + (remainder - 10)));

            }
            currentNum = currentNum / base;
        }
        char baseChar = intToChar(base);
        result.reverse();
        return result.append("b").append(baseChar).toString();
    }


    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        int num1 = number2Int(n1);
        int num2 = number2Int(n2);
        return num1 == num2;
    }


    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isNumber(arr[i])) {
                if (number2Int(arr[i]) > number2Int(arr[max])) {
                    max = i;
                }
            }
        }
        return max;
    }
}
