package lab2.zadanie1;

import lab2.zadanie1.zad1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class zad1Test {
    zad1 zadanie = new zad1();

    @Test
    void test1(){
        assertEquals(zadanie.LevQWERTY("pies", "koes"), 1.5, 0.001);
    }

    @Test
    void test2(){
        assertEquals(zadanie.LevQWERTY("kwiat", "kwist"), 0.5, 0.001);
    }

    @Test
    void test3(){
        assertEquals(zadanie.LevQWERTY("kot", "kita"), 1.5, 0.001);
    }

    @Test
    void test4(){
        assertEquals(zadanie.LevQWERTY("drab", "dal"), 2.0, 0.001);
    }

    @Test
    void test5(){
        assertEquals(zadanie.LevQWERTY("a", "b"), 1.0, 0.001);
    }

    @Test
    void test6(){
        assertEquals(zadanie.LevQWERTY("a", "s"), 0.5, 0.001);
    }

    @Test
    void test7(){
        assertEquals(zadanie.LevQWERTY("to jest to miejsce", "to jest to mieksce"), 0.5, 0.001);
    }
}