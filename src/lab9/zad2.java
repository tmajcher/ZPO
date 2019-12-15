package lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zad2 {

    public static List<Integer> smallPrimes = new ArrayList<>();
    public static int zakres = 100000000;
    public static boolean pierwsze[] = new boolean[zakres];

    public static void setSmallPrimes(){
        Arrays.fill(pierwsze, true);
        pierwsze[0]=false;
        pierwsze[1]=false;
        for(int i=2;i<=Math.sqrt(zakres);i++) {
            for(int t=i+i;t<zakres;t=t+i){
                pierwsze[t]=false;
            }
        }
        for (int i = 0; i < Math.sqrt(zakres) ; i++) {
            if(pierwsze[i])
                smallPrimes.add(i);
        }
    }

    public static int end(boolean[] tab){
        int counter = 0;
        for (int i = 0; i < tab.length ; i++) {
            if(tab[i])
                counter++;
            if(i == 1000000)
                System.out.println(counter);
            if(i == 10000000)
                System.out.println(counter);
            if(i == 100000000)
                System.out.println(counter);
        }
        return counter;
    }

    public static void main(String[] args) throws InterruptedException{
        setSmallPrimes();
        long start, stop;

        start = System.currentTimeMillis();
        boolean[] p1= podpunktA(2, smallPrimes);
        stop = System.currentTimeMillis();
        System.out.println("Czas wykonania (w milisekundach): "+(stop-start));

        Thread.sleep(1000);

        start=System.currentTimeMillis();
        boolean[] p2= podpunktA(4, smallPrimes);
        stop=System.currentTimeMillis();
        System.out.println("Czas wykonania (w milisekundach): "+(stop-start));

        Thread.sleep(1000);

        System.out.println(end(p1));
    }


    public static boolean[] podpunktA(int watki, List<Integer> smallPrimes) throws InterruptedException{
        List<Thread> lista = new ArrayList<>();
        boolean[] tab = new boolean[zakres];
        Arrays.fill(tab, true);
        tab[0] = false;
        tab[1] = false;

        for (int p = 0; p < watki; p++) {
            int finalP = p;
            lista.add(new Thread(() -> {
                for (int i = finalP; i < smallPrimes.size(); i += watki) {
                    int x = smallPrimes.get(i);
                    for (int j = x + x; j < zakres; j = j + x) {
                        tab[j] = false;
                    }
                }
            }));
        }
        for (int i = 0; i < watki ; i++) {
            lista.get(i).start();
        }
        return tab;
    }
}



