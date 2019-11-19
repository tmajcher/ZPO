package lab4;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class zad3Test {
    zad3 zadanie = new zad3();
    public static List<Double> li = List.of((double)-5100, 43.257, (double)200000, 2000000.5);

    @Test
    void test1() {
        List<String> fn = zadanie.formattedNumbers(li, 2, ',', 2, true);
        assertTrue(fn.size() == 4);
        assertTrue(fn.get(0).equals("    -51,00.00"));
        assertTrue(fn.get(1).equals("        43.26"));
        assertTrue(fn.get(2).equals("  20,00,00.00"));
        assertTrue(fn.get(3).equals("2,00,00,00.50"));
    }

    @Test
    void test2(){
        List<String> fn2 = zadanie.formattedNumbers(li, 3, '|', 2, false);
        assertTrue(fn2.size() == 4);
        assertTrue(fn2.get(0).equals("   -5|100"));
        assertTrue(fn2.get(1).equals("       43.26"));
        assertTrue(fn2.get(2).equals("  200|000"));
        assertTrue(fn2.get(3).equals("2|000|000.5"));
    }
}