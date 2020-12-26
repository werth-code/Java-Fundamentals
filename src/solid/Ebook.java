package solid;

public class Ebook extends Book{
    static String type = "PDF";
    Boolean hasEbook;

    public Ebook(String bookName, String bookText, String author) {
        super(bookName, bookText, author);
        this.hasEbook = true;
    }

    public Boolean getHasEbook() {
        return hasEbook;
    }

    public static String getType() {
        return type;
    }
}
