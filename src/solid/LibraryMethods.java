package solid;

public interface LibraryMethods {

    static void printLibrary(Library library) {
        library.getBooks().forEach(book -> System.out.println("| " + book.getBookName() + " |"));
    }
}
