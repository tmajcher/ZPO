package lab4;

import java.util.ArrayList;
import java.util.List;

public class zad3 {
    public static List<Double> li = List.of((double)-5100, 43.257, (double)200000, 2000000.5);

    public static List<String> formattedNumbers(List<Double> nums, int group, char separator, int nDigits, boolean padding){
        List<String> wynik = new ArrayList<>();
        String temp = "";
        int max_length = 0;
        double x = 0;
        double y = 0;

        /**
         *
         * Wstawianie seperatora
         *
         */
        for (int i = 0; i < li.size() ; i++) {
            temp = li.get(i).toString();
            for (int j = temp.indexOf('.')-group ; j > 0 ; j=j-group) {
                if(temp.charAt(j) == '-' || temp.charAt(j-1) == '-')
                    break;
                temp = temp.substring(0,j) + separator + temp.substring(j);
                if(max_length < temp.indexOf('.'))
                    max_length = temp.indexOf('.');
            }
            wynik.add(temp);
        }



        /**
         *
         * Wyrównanie długości względem nadłuższego stringa
         *
         */
        for (int i = 0; i < li.size() ; i++) {
            temp = wynik.get(i);
            if(temp.indexOf('.') < max_length){
                temp = " ".repeat(max_length - temp.indexOf('.')) + temp;
            }
            wynik.set(i, temp);
        }



        /**
         *
         * Padding i nDigits
         *
         */
        for (int i = 0; i < li.size() ; i++) {
            x = li.get(i);
            temp = wynik.get(i);
            if(padding){
                if(x == Math.rint(x))
                    temp = temp.substring(0, temp.indexOf('.') + 1) + "0".repeat(nDigits);
                else {
                    x = (Math.round((x%(int)x) * Math.pow(10, nDigits)));
                    temp = temp.substring(0, temp.indexOf('.') + 1) + (int)x;
                }
            }
            if(!padding){
                if(x == Math.rint(x))
                    temp = temp.substring(0, temp.indexOf('.'));
                else {
                    y = (Math.round((x%(int)x) * Math.pow(10, nDigits)));
                    if(y % 10 == 0)
                        x = (Math.round((x%(int)x) * Math.pow(10, nDigits - 1)));
                    else x = y;
                    temp = temp.substring(0, temp.indexOf('.') + 1) + (int)x;
                }
            }
            wynik.set(i, temp);
        }
        return wynik;
    }


    public static void main(String[] args) {
        List<String> fn = formattedNumbers(li, 2, ',', 2, true);
        for (int i = 0; i < fn.size() ; i++) {
            System.out.println(fn.get(i));
        }
        System.out.println();
        List<String> fn2 = formattedNumbers(li, 3, '|', 2, false);
        for (int i = 0; i < fn.size() ; i++) {
            System.out.println(fn2.get(i));
        }
    }
}


/*
List<String> fn = formattedNumbers(li, 2, ',', 2, true);
assertTrue(fn.size() == 4);
assertTrue(fn.get(0).equals("    -51,00.00"));
assertTrue(fn.get(1).equals("        43.26"));
assertTrue(fn.get(2).equals("  20,00,00.00"));
assertTrue(fn.get(3).equals("2,00,00,00.50"));


List<String> fn2 = formattedNumbers(li, 3, '|', 2, false);
assertTrue(fn2.size() == 4);
assertTrue(fn2.get(0).equals("     -510"));
assertTrue(fn2.get(1).equals("       43.26"));
assertTrue(fn2.get(2).equals("  200|000"));
assertTrue(fn2.get(3).equals("2|000|000.5"));
 */