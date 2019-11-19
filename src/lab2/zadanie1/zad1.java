package lab2.zadanie1;

import java.util.HashMap;

public class zad1 {

    public static HashMap<Character, String> dictionary = new HashMap<Character, String>();

    public static void setMap(){
        dictionary.put('q', "ww");
        dictionary.put('w', "qe");
        dictionary.put('e', "wr");
        dictionary.put('r', "et");
        dictionary.put('t', "ry");
        dictionary.put('y', "tu");
        dictionary.put('u', "yi");
        dictionary.put('i', "uo");
        dictionary.put('o', "ip");
        dictionary.put('p', "oo");

        dictionary.put('a', "ss");
        dictionary.put('s', "ad");
        dictionary.put('d', "sf");
        dictionary.put('f', "dg");
        dictionary.put('g', "fh");
        dictionary.put('h', "gj");
        dictionary.put('j', "hk");
        dictionary.put('k', "jl");
        dictionary.put('l', "kk");

        dictionary.put('z', "xx");
        dictionary.put('x', "zc");
        dictionary.put('c', "xv");
        dictionary.put('v', "cb");
        dictionary.put('b', "vn");
        dictionary.put('n', "bm");
        dictionary.put('m', "nn");
        dictionary.put(' ', "  ");
    }

    public static double LevQWERTY(String s1, String s2){
        setMap();
        int i, j, m, n;
        double d[][], cost;

        m = s1.length();
        n = s2.length();

        d = new double[m+1][n+1];

        for (i=0; i<=m; i++)
            d[i][0] = i;
        for (j=1; j<=n; j++)
            d[0][j] = j;

        for (i=1; i<=m; i++)
        {
            for (j=1; j<=n; j++)
            {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    cost = 0;
                else if( s1.charAt(i-1) == (dictionary.get(s2.charAt(j-1))).charAt(0) || s1.charAt(i-1) == (dictionary.get(s2.charAt(j-1))).charAt(1))
                    cost = 0.5;
                else
                    cost = 1;

                d[i][j] = Math.min(d[i-1][j] + 1,         /* remove */
                        Math.min(d[i][j-1] + 1,      /* insert */
                                d[i-1][j-1] + cost));   /* change */
            }
        }

        return d[m][n];
    }

    public static void main(String[] args) {
        System.out.println(LevQWERTY("to jest to miejsce", "to jest to mieksce"));
    }
}