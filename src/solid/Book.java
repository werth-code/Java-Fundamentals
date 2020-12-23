package solid;

/* Single Responsibility
We create a book class - it should have a single responsibility. It does not need to implement any methods that
do not explicitly deal with this exact type of book.

This way, we can create other types of books and all functionality will be integrated seamlessly without having to
@Override methods and alter code.
*/

public class Book implements Readable {
    String bookName;
    String bookText;
    String author;

    public Book(String bookName, String bookText, String author) {
        this.bookName = bookName;
        this.bookText = bookText;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookText() {
        return bookText;
    }

    public void setBookText(String bookText) {
        this.bookText = bookText;
    }

    public String containsWord(String word) {
        if(this.bookText.contains(word)) return word;
        else return null;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public void read() {
        System.out.println(this.getBookName() + " by " + this.getAuthor() + "\n"
                + this.getBookText());
    }
}
