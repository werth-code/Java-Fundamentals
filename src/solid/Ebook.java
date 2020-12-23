package solid;

public class Ebook extends Book{
    Boolean hasEbook;

    public Ebook(String bookName, String bookText, String author) {
        super(bookName, bookText, author);
        this.hasEbook = true;
    }

    public Boolean getHasEbook() {
        return hasEbook;
    }
}
