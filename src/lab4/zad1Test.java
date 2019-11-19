package lab4;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class zad1Test {

    public static String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
            "Zyta", "Órszula", "Świętopełk"};

    public static Collator c = Collator.getInstance(new Locale("pl", "PL"));

    @Test
    void sortStrings() {
        String[] temp = names.clone();
        zad1.sortStrings(c, temp);
        assertEquals("Agnieszka",   temp[0]);
        assertEquals("Darek",       temp[1]);
        assertEquals("Łukasz",      temp[2]);
        assertEquals("Órszula",     temp[3]);
        assertEquals("Stefania",    temp[4]);
        assertEquals("Ścibor",      temp[5]);
        assertEquals("Świętopełk",  temp[6]);
        assertEquals("Zyta",        temp[7]);
    }

    @Test
    void fastSortStrings() {
        String[] temp = names.clone();
        zad1.fastSortStrings(c, temp);
        assertEquals("Agnieszka",   temp[0]);
        assertEquals("Darek",       temp[1]);
        assertEquals("Łukasz",      temp[2]);
        assertEquals("Órszula",     temp[3]);
        assertEquals("Stefania",    temp[4]);
        assertEquals("Ścibor",      temp[5]);
        assertEquals("Świętopełk",  temp[6]);
        assertEquals("Zyta",        temp[7]);
    }

    @Test
    void fastSortStrings2() {
        String[] temp = names.clone();
        zad1.fastSortStrings2(c, temp);
        assertEquals("Agnieszka",   temp[0]);
        assertEquals("Darek",       temp[1]);
        assertEquals("Łukasz",      temp[2]);
        assertEquals("Órszula",     temp[3]);
        assertEquals("Stefania",    temp[4]);
        assertEquals("Ścibor",      temp[5]);
        assertEquals("Świętopełk",  temp[6]);
        assertEquals("Zyta",        temp[7]);
    }
}