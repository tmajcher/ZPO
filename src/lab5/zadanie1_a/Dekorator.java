package lab5.zadanie1_a;

public abstract class Dekorator implements Publikacja {
    private Publikacja k;

    public Dekorator(Publikacja k){
        this.k = k;
    }

    @Override
    public String toString() {
        return k.toString();
    }

    @Override
    public String getAutor() {
        return k.getAutor();
    }

    @Override
    public String getTitle() {
        return k.getTitle();
    }

    @Override
    public int getPages() {
        return k.getPages();
    }
}


class KsiazkaZOkladkaTwarda extends Dekorator {
    private String okladka;
    private Publikacja k;

    public KsiazkaZOkladkaTwarda(Publikacja k) throws Exception{
        super(k);
        okladka = "Okładka twarda";
        String temp = super.toString();
        if(temp.contains("Okładka zwykła") || temp.contains("Okładka twarda"))
            throw new Exception("Nie może być dwóch okładek");
    }

    @Override
    public String getAutor() {
        return super.getAutor();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public int getPages() {
        return super.getPages();
    }

    public String getOkladka() {
        return okladka;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getOkladka() + " |";
    }
}


class KsiazkaZOkladkaZwykla extends Dekorator{
    private String okladka;
    private Publikacja k;

    public KsiazkaZOkladkaZwykla(Publikacja k) throws Exception{
        super(k);
        okladka = "Okładka zwykła";
        String temp = super.toString();
        if(temp.contains("Okładka zwykła") || temp.contains("Okładka twarda"))
            throw new Exception("Nie może być dwóch okładek");
    }

    @Override
    public String getAutor() {
        return super.getAutor();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public int getPages() {
        return super.getPages();
    }

    public String getOkladka() {
        return okladka;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getOkladka() + " |";
    }
}


class KsiazkaZAutografem extends Dekorator{
    private String autograf;
    private Publikacja k;

    public KsiazkaZAutografem(Publikacja k, String autograf) throws Exception{
        super(k);
        this.autograf = autograf;
        String temp = super.toString();

    }

    @Override
    public String getAutor() {
        return super.getAutor();
    }

    @Override
    public String getTitle() { return super.getTitle(); }

    @Override
    public int getPages() { return super.getPages(); }

    public String getAutograf() {
        return autograf;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getAutograf() + " |";
    }
}


class KsiazkaZObwoluta extends Dekorator {
    private Publikacja k;
    private String obwoluta;

    public KsiazkaZObwoluta(Publikacja k) throws Exception{
        super(k);
        obwoluta = "Z obwolutą";
        String temp = super.toString();
        if(!temp.contains("Okładka zwykła") && !temp.contains("Okładka twarda"))
            throw new Exception("Nie może być obwoluty bez okładki");
        if(temp.contains("Z obwolutą"))
            throw new Exception("Może być tylko jedna obwoluta");
    }

    @Override
    public String getAutor() {
        return super.getAutor();
    }

    @Override
    public String getTitle() { return super.getTitle(); }

    @Override
    public int getPages() { return super.getPages(); }

    public String getObwoluta() {
        return obwoluta;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getObwoluta() + " |";
    }
}
