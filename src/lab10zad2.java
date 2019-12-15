import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class lab10zad2 {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("Factorial");
        CtMethod m[] = cc.getDeclaredMethods();
        for (CtMethod c:m){
            if(c.getName().equals("main"))
                continue;
            c.useCflow(c.getName());
            c.insertBefore("if ($cflow(" + c.getName() + ") == 1)"
                    + "    System.out.println(\"" + c.getName() + " - recursive \");");
        }

        cc.writeFile("C:\\Users\\Tomek\\Dropbox\\Semestr 5\\zpo\\out\\production\\zpo");
    }
}
