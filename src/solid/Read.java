package solid;

public class Read {
    public static void read(Book book) {
        System.out.println(book.getBookName() + " by " + book.getAuthor() + "\n"
                + book.getBookText());
    }
}
