import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(11, v);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }
    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (String s : good) {
            boolean ok = Ex1.isNumber(s);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", " 1 2 b2", null, "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            boolean not_ok = Ex1.isNumber(s);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        int i = 1234567;
        String sa, s = Ex1.int2Number(i,16);
        int i2 = Ex1.number2Int(s);
        assertEquals(i, i2);
        int i3 = 0;
        sa = Ex1.int2Number(i3,2);
        i3 = Ex1.number2Int(sa);
        int i4 = 2147483647;
        s = Ex1.int2Number(i4,2);
        assertTrue(i4 != i3);
        int i5 = Ex1.number2Int(s) - i4;
        assertEquals(i3, i5);
        assert s.length()>31;
        assertEquals(i4, (Math.pow(2,31)-1));
    }
    @Test
    void maxIndexTest() {
        String[] max = new String[]{"1", "91323DFbG", "6", "3FbG", "44", "543FFFbG", "6", "7bC" , "13223232b4"};
        boolean isMax = Ex1.maxIndex(max) == 1;
        assertTrue(isMax);
        if (Ex1.maxIndex(max) != 1) {
            fail();
        }
        String[] ms = {""};
        for (String m : ms) {
            for (int j = 0; j < ms.length; j++) {
                int c = 0;
                if (Ex1.isNumber(m)) {
                    c = Ex1.maxIndex(ms);
                }
                if (c > 0) {
                    System.out.println(c);
                }
            }
        }

    }

    @Test
    void intToChar() {
        for (int i = 0; i < 10; i++) {
            char[] isChar = new char[10];
            isChar[i] = Ex1.intToChar(i);
            assertTrue(isChar[i] >= '0' && isChar[i] <= '9');
        }
        IntStream.range(10, 17).forEach(i -> {
            char[] isChar = new char[17];
            isChar[i] = Ex1.intToChar(i);
            assertTrue(isChar[i] >= 'A' && isChar[i] <= 'G');
        });
    }

    @Test
    void charToInt() {
        for (int i = 0; i < 10; i++) {
            char[] x = new char[10];
            x[i] = Ex1.intToChar(i);
            int i2 = Ex1.charToInt(x[i]);
            for (int j = 2; j < 16; j++) {
                int base2 = j + 1;
                String a = Ex1.int2Number(i2, j);
                String b = Ex1.int2Number(i, base2);
                assertTrue(Ex1.equals(a, b));
            }
        }
    }

    @Test
    void number2Int() {

    }

    @Test
    void isNumInBase() {
        var good = new String[]{"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        Arrays.stream(good).forEach(s -> {
            boolean ok = Ex1.isNumber(s);
            assertTrue(ok);
        });
        String[] not_good = {"b2", "2b2", " 1 2 b2", null, "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            boolean not_ok = Ex1.isNumber(s);
            assertFalse(not_ok);
        }
    }

    @Test
    void isBase() {
        for (int i = 2; i < 10; i++) {
            String basis = Ex1.int2Number(i, 10);
            if (Ex1.isNumber(basis)) {
                assertTrue(Ex1.isBase(basis));
            }
        }
        for (int i = 10; i < 17; i++) {
            /*
             Since we know we have exactly 7 2-digits valid bases, and my isBase uses several
             other functions in my main code before applying the check, to ensure my base
             is in a single character, in order to test all possible bases here, I will subtract
             7 from the basis, so that it will return true for all the right bases, and false otherwise.
             */
            String basis = Ex1.int2Number(i-7, 10);
            if (Ex1.isNumber(basis)) {
                assertTrue(Ex1.isBase(basis));
            }
        }
        for (int i = 0; (i <= 1) || (i >= 17); i++) {
            String basis = Ex1.int2Number(i,10);
            if (Ex1.isNumber(basis)){
                assertFalse(Ex1.isBase(basis));
            }
        }
    }

    @Test
    void isNumber() { // This test is basically the same as the first one
        String[] good = {"1", "0bG", "1b2", "01b2", "123bA", "FbG", "0",  "ABbG", "0bA"};
        for (String s : good) {
            boolean ok = Ex1.isNumber(s);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", " 1 2 b2", null, "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            boolean not_ok = Ex1.isNumber(s);
            assertFalse(not_ok);
        }
    }
     @Test
    void testEquals() {
        assertFalse(Ex1.equals("10b2", "10b3"));
        assertTrue(Ex1.equals("4095", "FFFbG"));
        for (int i = 0; i < 17; i++) {
            char s = Ex1.intToChar(i);
            String a = "" + s;
            if (Ex1.isNumber(a)) {
                String sts = "0";
                String sub = "0b" + s;
            } else {
                assertFalse(Ex1.isNumber(a));
            }
        }
    }
}
