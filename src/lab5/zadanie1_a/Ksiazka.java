package lab5.zadanie1_a;

public class Ksiazka implements Publikacja {
    private String autor, title;
    private int pages;

    Ksiazka(String autor, String title, int pages){
        this.autor = autor;
        this.title = title;
        this.pages = pages;
    }

    @Override
    public int getPages() {
        return pages;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "| " + getAutor() + " | " + getTitle() + " | " + getPages() + " |";
    }
}
