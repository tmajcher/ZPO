package lab6.zad1;

import javax.xml.datatype.Duration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class zad1 {
    public static Scanner scan = null;
    public static String text = null;
    public static List<Integer> zarobki = new ArrayList<>();
    public static Map<String, Integer> map = new LinkedHashMap<>();
    public static String key = null;

    public static void main(String[] args) {
        try {
            scan = new Scanner(new File("src/lab6/zad1/dane.txt"));
            for (int i = 0; scan.hasNextLine() ; i++) {
                text = scan.nextLine();
                key = text.substring(text.lastIndexOf(' ') - 2, text.lastIndexOf(' '));
                map.merge(key, 1, Integer::sum);

                if(!text.contains("PL"))
                    continue;
                zarobki.add(Integer.parseInt(text.substring(text.lastIndexOf(' ') + 1)));
            }
            Collections.sort(zarobki);

            int suma = zarobki.get(zarobki.size()-1) + zarobki.get(zarobki.size()-2);
            System.out.println("Suma zarobków 2 najelepiej zarabiających polaków: " + suma);

            suma = zarobki.get(0) + zarobki.get(1);
            System.out.println("Suma zarobków 2 najgorzej zarabiających polaków: " + suma);

            System.out.println(map);
        }
        catch(FileNotFoundException e){
            System.out.println("Nie znaleziono pliku");
        }

    }
}
