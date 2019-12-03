import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> lista = List.of(4, 10, 3, 7, 4, 1, 6, 2);

    public static void main(String[] args) throws  Exception{
        String className = "MaxSearchAlgorithms";
        Class c = Class.forName(className);
        Method[] methods = c.getDeclaredMethods();
        for (Method m:methods){
            if(m.getName().contains("scan"))
                System.out.println("Metoda " + m.getName() + " zwraca: " + m.invoke(c.newInstance(), lista));
        }

    }
}
