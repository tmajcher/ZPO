package lab10;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class zad3 {

    public static List<Model> listaGier = new ArrayList<>();
    public static List<Integer> wylosowaneLiczby = new ArrayList<>();
    public static List<String> listaMiesiecy = List.of("Stycznia", "Lutego", "Marca", "Kwietnia",
                                        "Maja", "Czerwca", "Lipca", "Sierpnia",
                                        "Września", "Października", "Listopada", "Grudnia");

    public static void main(String[] args) throws IOException {
        String url = "http://megalotto.pl/wyniki";
        String name, urlGame;
        int index=1;
        Scanner scan = new Scanner(System.in);
        Document doc = Jsoup.connect(url).get();
        Elements gry = doc.getElementsByClass("czarny");

        System.out.println("Wybierz gre:");
        for (Element x:gry) {
            name = x.text();
            if(name.equals("Gra"))
                continue;
            urlGame = x.html().split("\"")[1];
            listaGier.add(new Model(name, urlGame));
            System.out.println(index + ". " + name);
            index++;
        }
        int indexOfGame = scan.nextInt();
        System.out.println("Wybrales gre " + listaGier.get(indexOfGame-1).getName());
        System.out.println("Co chcesz zrobić?\n" +
                "1. Pokaż wyniki losowania w danycm dniu\n" +
                "2. Pokaż histogram wylosowanych liczb w danym roku\n" +
                "3. Pokaż histogram wylosowanych liczb w danym przedziale czasowym");
        int option = scan.nextInt();
        scan.nextLine();

        switch(option){
            case 1: {
                System.out.println("Wprowadz date w danym formacie yyyy-mm-dd");
                LocalDate date = LocalDate.parse(scan.nextLine());
                System.out.println(getResultFromDate(date, listaGier.get(indexOfGame-1).getUrl()));
                break;
            }
            case 2:{
                System.out.println("Wprowadz rok");
                int year = scan.nextInt();
                System.out.println(getHistogramFromYear(year, listaGier.get(indexOfGame-1).getUrl()));
                break;
            }
            case 3:{
                System.out.println("Wprowadz date początkową w danym formacie yyyy-mm-dd");
                LocalDate startDate = LocalDate.parse(scan.nextLine());
                System.out.println("Wprowadz date końcową w danym formacie yyyy-mm-dd");
                LocalDate endDate = LocalDate.parse(scan.nextLine());
                System.out.println(getHistogramBetweenDates(startDate, endDate, listaGier.get(indexOfGame-1).getUrl()));
                break;
            }
            default:{
                System.out.println("Wprowadzono zły numer");
            }
        }

    }

    public static Map<Integer, Integer> getHistogramFromYear(int year, String url) throws IOException{
        Map<Integer, Integer> mapaLosowan = new HashMap<>();
        Document doc = Jsoup.connect(url + "/losowania-z-roku-" + year).get();
        Elements temp1 = doc.getElementsByClass("numbers_in_list");
        for (Element x:temp1) {
            mapaLosowan.merge(Integer.parseInt(x.text()), 1, Integer::sum);
        }
        return mapaLosowan;
    }

    public static Map<Integer, Integer> getHistogramBetweenDates(LocalDate startDate, LocalDate endDate, String url) throws IOException{
        Map<Integer, Integer> mapaLosowan = new HashMap<>();
        Document doc = Jsoup.connect(url + "/losowania-od-" + startDate.getDayOfMonth() + "-" + listaMiesiecy.get(startDate.getMonthValue()-1) + "-" + startDate.getYear() + "-do-" + endDate.getDayOfMonth() + "-"  + listaMiesiecy.get(endDate.getMonthValue()-1) + "-" + endDate.getYear()).get();
        Elements temp1 = doc.getElementsByClass("numbers_in_list");
        for (Element x:temp1) {
            mapaLosowan.merge(Integer.parseInt(x.text()), 1, Integer::sum);
        }
        return mapaLosowan;
    }

    public static List<Integer> getResultFromDate(LocalDate date, String url) throws IOException{
        List<Integer> results = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Document doc = Jsoup.connect(url + "/losowania-z-roku-" + date.getYear()).get();
        Elements temp1 = doc.getElementsByClass("date_in_list");
        Elements temp2 = null;

        for (Element x:temp1){
            if(x.text().equals(date.format(format))){
                temp2 = x.nextElementSiblings();
                for (Element y:temp2){
                    if(y.className().equals("numbers_in_list"))
                        results.add(Integer.parseInt(y.text()));
                }
            }
        }

        return results;
    }
}
