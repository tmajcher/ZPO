package lab8;

import java.util.ArrayList;
import java.util.List;

public class zad3{

    public static void main(String[] args) {
        try {
            List<watek> lista = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                lista.add(new watek(i));
                lista.get(i).start();
                lista.get(i).join();
            }
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }

    static class watek extends Thread{
        int id;

        watek(int id){
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Hello from task: " + id);
        }
    }
}