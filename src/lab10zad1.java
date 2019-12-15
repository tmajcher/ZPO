import javassist.*;

import java.io.IOException;

public class lab10zad1 {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException, NoSuchMethodException {
        CtClass cc = ClassPool.getDefault().get("Point");

        CtMethod m = cc.getDeclaredMethod("move");
        m.setBody("{System.out.println($1);" +
                "System.out.println($2);" +
                "this.x += $2;" +
                "this.y += $1;}");

        cc.writeFile("C:\\Users\\Tomek\\Dropbox\\Semestr 5\\zpo\\out\\production\\zpo");
    }
}