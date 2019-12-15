package lab9;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class zad3 {

    public static ExecutorService threadPool = Executors.newCachedThreadPool();
    public static ExecutorService threadPool1 = Executors.newCachedThreadPool();
    public static List<Osoba> osoby = new ArrayList<>();
    public static List<Widz> widzowie = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Osoby zaczynają się namyślać");
        for (int i = 0; i < 100 ; i++) {
            osoby.add(new Osoba(0.05));
            threadPool.submit(osoby.get(i));
        }
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
        long iloscOsob = osoby.stream().filter(Osoba::isDecyzja).count();
        if(iloscOsob < 5)
            System.out.println("Przepraszamy filmu nie będzie");
        else {
            System.out.println("Film będzie oglądać " + iloscOsob + " osób");

            Thread.sleep(2000);

            for (int i = 0; i < iloscOsob; i++) {
                widzowie.add(new Widz(0.7));
                threadPool1.submit(widzowie.get(i));
            }
            threadPool1.shutdown();
            long iloscWidzow = widzowie.stream().filter(Widz::isDecyzja).count();
            if (iloscWidzow < 5)
                System.out.println("Frajerzy");
            else {
                System.out.println("Film nadal ogląda " + iloscWidzow + " osób");

                Thread.sleep(2000);
                System.out.println("Koniec filmu");
            }
        }
    }
}

class Osoba extends Thread{
    private double szansa;

    public boolean isDecyzja() {
        return decyzja;
    }

    private boolean decyzja;

    private Random rand = new Random();

    Osoba(double szansa){
        this.szansa = szansa;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * rand.nextInt(4) + 1000);
            if (rand.nextDouble() < szansa)
                decyzja = true;
            else
                decyzja = false;
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
}

class Widz extends Thread{
    private double szansa;

    public boolean isDecyzja() {
        return decyzja;
    }

    private boolean decyzja;

    private Random rand = new Random();

    Widz(double szansa){
        this.szansa = szansa;
    }

    @Override
    public void run() {
            if (rand.nextDouble() < szansa)
                decyzja = true;
            else
                decyzja = false;
    }
}