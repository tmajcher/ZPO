package lab2.zadanie2;

public class zad2 {
    public static String str = "--";

    /**
     *
     * @param a  pierwszy argument oznaczajacy ilosc segmentow
     * @param b  drugi parametr oznaczajacy "glebokosc" rysowanego segmentu
     * @param flag  wartosc od jakiej program liczy segemnty
     */


    public static void draw(int a, int b, int flag){

        if(a == flag) {
            System.out.println(str.repeat(b) + " " + flag);
            return;
        }

        int counter = 1, length = (int)Math.pow(2, b-1);

        int[] tab = new int[length+1];
        System.out.println(str.repeat(b) + " " + flag);


        for (int i = 1; i < b ; i++) {
            for (int j = (int)Math.pow(2, i-1); j < length; j+= Math.pow(2, i)) {
                tab[j] = i;
            }
        }

        for (int i = 1; i < length ; i++) {
            if(tab[i] < b){
                System.out.print(" ".repeat(b-tab[i]));
            }
            System.out.println(str.repeat(tab[i]));
        }

        draw(a, b, flag+1);
    }

    public static void main(String[] args) {
        draw(2,5, 0);
    }
}
