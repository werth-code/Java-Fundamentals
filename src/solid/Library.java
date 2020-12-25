package solid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library implements LibraryMethods {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    // // TODO: 12/23/20 CREATE A LIBRARY, THEN AN INTERFACE WITH LIBRARY METHODS..
    public void addBook(Book book) {
        this.books.add(book);
    }

}
