package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class lab3 {

    class kolarz{

    }
    public static final int numbers_of_cyclist = 12;

    public static Set<String> cyclists = new HashSet<>();
    public static List<String> kolarze = new ArrayList<>();
    public static Random rand = new Random();

    public static void readURL(String link) throws IOException
    {
        URL oracle = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
            kolarze.add(inputLine);
        }
        in.close();

        for (int i = 0; i < numbers_of_cyclist ; i++) {
            if(cyclists.add(kolarze.get(rand.nextInt(kolarze.size()))))
                continue;
            else
                i--;
        }
        kolarze.clear();
        kolarze.addAll(cyclists);
    }

    public static void main(String[] args) {
        try{readURL("http://szgrabowski.kis.p.lodz.pl/zpo19/nazwiska.txt");}
        catch (IOException e){
            System.out.println("Błąd");
            return;
        }
        int[] czasy = new int[12];
        for (int i = 0; i < 12 ; i++) {
            czasy[i] = (int)(rand.nextGaussian() * 40 + 290);
            if(czasy[i] < 240)          czasy[i] = 240;
            else if(czasy[i] > 350)     czasy[i] = 350;
        }
        for (int i = 0; i < 12 ; i++) {
            System.out.print(kolarze.get(i) + " ");
            System.out.println(czasy[i]);
        }


    }

}
