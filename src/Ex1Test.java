import org.junit.jupiter.api.Test;
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
           String s = Ex1.int2Number(i,16);
           int i2 = Ex1.number2Int(s);
           assertEquals(i, i2);
           int i3 = 0;
           s = Ex1.int2Number(i3,2);
           int i4 = 2147483647;
           s = Ex1.int2Number(i4,2);
           int i5 = Ex1.number2Int(s) - i4;
           assertEquals(i3, i5);
           assert s.length()>31;
           assertEquals(i4, (Math.pow(2,31)-1));
        }
        @Test
        void maxIndexTest() {
            // implement this test
        }

        // Add additional test functions - test as much as you can.
    }
