package lab6.zad2;

import java.util.LinkedHashMap;
import java.util.Map;

public class zad2 {

    public static Map<String, Integer> counts = new LinkedHashMap<>();
    public static String text = "przykładowy tekst który zawiera jakies powtórzenie jakies powtórzenie";

    public static void merge(String[] words, Map<String, Integer> map){
        for (String word: words) {
            map.merge(word, 1, Integer::sum);
        }
    }

    public static void containsKey(String[] words, Map<String, Integer> map){
        for (String word:words) {
            if(!map.containsKey(word))
                map.put(word, 1);
            else
                map.put(word, map.get(word)+1);
        }
    }

    public static void getnull(String[] words, Map<String, Integer> map){
        for (String word:words) {
            if(map.get(word) == null)
                map.put(word, 1);
            else
                map.put(word, map.get(word)+1);
        }
    }

    public static void getOrDefault(String[] words, Map<String, Integer> map){
        for (String word:words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
    }

    public static void putIfAbsent(String[] words, Map<String, Integer> map){
        for (String word:words) {
            Integer liczba = map.putIfAbsent(word, 1);
            if(liczba != null)
                map.put(word, liczba+1);
        }
    }

    public static void main(String[] args) {

        String temp[] = text.split(" ");

        //merge(temp);
        //containsKey(temp);
        //getnull(temp);
        //getOrDefault(temp);
        //putIfAbsent(temp);

        System.out.println(counts);
    }
}
