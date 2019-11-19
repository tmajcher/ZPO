package lab4;

import java.text.Collator;
import java.util.*;


public class zad1 {

    public static String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
            "Zyta", "Órszula", "Świętopełk"};

    public static Collator c = Collator.getInstance(new Locale("pl", "PL"));

    public static void sortStrings(Collator collator, String[] words) {
        String x = "";
        int j = 0;

        for (int i = 1; i < words.length; i++) {
            x = words[i];
            j = i - 1;
            while ((j >= 0) && (collator.compare(x, words[j]) < 0)) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = x;
        }
    }

    public static void fastSortStrings(Collator collator, String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return collator.compare(o1, o2);
            }
        });
    }

    public static void fastSortStrings2(Collator collator, String[] words) {
        Arrays.sort(words, (String source, String target) -> collator.compare(source, target));
    }

    public static void main(String args[]) {

        long start;
        double end;

        start = System.nanoTime();
        for(int i=0; i<1; i++){
            String[] copy_names = names.clone();
            sortStrings(c, copy_names);
            for (String x:copy_names
                 ) {
                System.out.println(x);

            }
        }
        end = (System.nanoTime() - start)/1000000000.0;
        System.out.println("sortString - " + end + "s");



        start = System.nanoTime();
        for(int i=0; i<100000; i++){
            String[] copy_names = names.clone();
            fastSortStrings(c, copy_names);
        }
        end = (System.nanoTime() - start)/1000000000.0;
        System.out.println("fastSortString - " + end + "s");



        start = System.nanoTime();
        for(int i=0; i<100000; i++){
            String[] copy_names = names.clone();
            fastSortStrings2(c, copy_names);
        }
        end = (System.nanoTime() - start)/1000000000.0;
        System.out.println("fastSortString2 - " + end + "s");
    }


}
