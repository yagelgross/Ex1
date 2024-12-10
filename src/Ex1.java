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
        public static int charToInt(char c) {
            int ans = 0;
            char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c) {
                    ans = i;
                }
            }
            return ans;
        }
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return string
         */
        public static int number2Int(String num) {
            int ans = 0;
            int base;
            if (!isNumber(num)) {
                return -1;
            }
            else {
                for (int i = 0; i < num.length(); i++) {
                    char ch = num.charAt(i);
                    if (ch == 'b'){
                        String[] parts = num.split("b");
                        String numPart = parts[0];
                        String basePart = parts[1];
                        char[] basis = basePart.toCharArray();
                        if(Character.isDigit(basis[0])){
                            base = Integer.parseInt(basePart);
                        } else {
                            base = charToInt(basis[0]);
                        }
                        for (int j = 1; j < numPart.length(); j++) {
                            char ch2 = numPart.charAt(j);
                            int sum = Integer.parseInt(String.valueOf(ch2));
                            sum += (int) (sum * Math.pow(base, numPart.length() - j-1)); // the conversion according to the weight of the number
                            ans += sum;
                        }
                    } else {
                        ans = Integer.parseInt(String.valueOf(ch));
                    }
                }
                return ans;
            }
        }


        public static boolean isNumInBase (String num, int base) { // an assistance function
            boolean ans = true;
            String isNum = "0123456789ABCDEF".substring(0,base); // all the valid numbers according to the base

            for (int i = 0; i < num.length(); i++) { // test all the numbers in the string
                char j = num.charAt(i); // for char at the (i) location
                if (isNum.indexOf(j) == -1) { // is the value of char valid?
                    ans = false; // if not ans = false
                }
            }
            return ans;
        }


        public static boolean isBase(String base) {
            if (base == null || base.isEmpty()) { // if the base is empty or has no value
                return false;
            }
            for(int i = 0; i < base.length(); i++) {
                char c = base.charAt(i); // the base character is c
                if (c < '0' || c > '9') { // if the value of c is not a base value
                    return false;
                }
            }
            int b = 0;
            for(int i = 0; i < base.length(); i++) {
                b = b * 10 + (base.charAt(i) - '0');
            }
            return b >= 2 && b <= 16; // return true or false according to the value of b
        }


        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (!(c == 'b')){
                    if (c < '0' || c > '9' || !Character.isDigit(c)) {
                        return false;
                    } else if (c >= '0' && c <= '9') {
                        return true;
                    }
                }
            }
            String[] parts = a.split("b");
            if (parts.length != 2) {
                return false;
            }
            String num = parts[0];
            String base1 = parts[1];
            if (!isBase(base1)) {
                return false;
            }
            int base = Integer.parseInt(base1);
            return isNumInBase(num,base);
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
            StringBuilder ans = new StringBuilder();
            int i = num;
            while (i > 0) {
                int j = i % base;
                if (j < 10) {
                    ans.append((char) (j + '0'));
                } else {
                    ans.append((char) ('A' + (j - 10)));
                }
                i = i / base;
            }
            char b = 0;
            if (base >= 10 && base <= 16) {
                b += (char) ('A' + (base - 10));
                ans.append("b" + b);
            } else { ans.append("b" + base);}
            ans.reverse().toString();
            return ans.toString();
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true if the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;

            return ans;
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
            int ans = 0;

            return ans;
        }
}
