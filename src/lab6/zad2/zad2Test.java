package lab6.zad2;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class zad2Test {

    Map<String, Integer> map = new LinkedHashMap<>();
    String text = "to jest tekst tekst";
    String temp[] = text.split(" ");

    String text2 = "przykładowy tekst który zawiera jakies powtórzenie jakies powtórzenie";
    String temp2[] = text2.split(" ");

    @Test
    void containsKey() {
        zad2.containsKey(temp, map);
        assertEquals(1, map.get("to"));
        assertEquals(1, map.get("jest"));
        assertEquals(2, map.get("tekst"));
    }

    @Test
    void containsKey2() {
        zad2.containsKey(temp2, map);
        assertEquals(1, map.get("przykładowy"));
        assertEquals(1, map.get("tekst"));
        assertEquals(1, map.get("który"));
        assertEquals(1, map.get("zawiera"));
        assertEquals(2, map.get("jakies"));
        assertEquals(2, map.get("powtórzenie"));
    }

    @Test
    void getnull() {
        zad2.getnull(temp, map);
        assertEquals(1, map.get("to"));
        assertEquals(1, map.get("jest"));
        assertEquals(2, map.get("tekst"));
    }

    @Test
    void getnull2() {
        zad2.getnull(temp2, map);
        assertEquals(1, map.get("przykładowy"));
        assertEquals(1, map.get("tekst"));
        assertEquals(1, map.get("który"));
        assertEquals(1, map.get("zawiera"));
        assertEquals(2, map.get("jakies"));
        assertEquals(2, map.get("powtórzenie"));
    }

    @Test
    void getOrDefault() {
        zad2.getOrDefault(temp, map);
        assertEquals(1, map.get("to"));
        assertEquals(1, map.get("jest"));
        assertEquals(2, map.get("tekst"));
    }

    @Test
    void getOrDefault2() {
        zad2.getOrDefault(temp2, map);
        assertEquals(1, map.get("przykładowy"));
        assertEquals(1, map.get("tekst"));
        assertEquals(1, map.get("który"));
        assertEquals(1, map.get("zawiera"));
        assertEquals(2, map.get("jakies"));
        assertEquals(2, map.get("powtórzenie"));
    }

    @Test
    void putIfAbsent() {
        zad2.putIfAbsent(temp, map);
        assertEquals(1, map.get("to"));
        assertEquals(1, map.get("jest"));
        assertEquals(2, map.get("tekst"));
    }

    @Test
    void putIfAbsent2() {
        zad2.putIfAbsent(temp2, map);
        assertEquals(1, map.get("przykładowy"));
        assertEquals(1, map.get("tekst"));
        assertEquals(1, map.get("który"));
        assertEquals(1, map.get("zawiera"));
        assertEquals(2, map.get("jakies"));
        assertEquals(2, map.get("powtórzenie"));
    }
}