package solid;

/* Single Responsibility
We create a book class - it should have a single responsibility. It does not need to implement any methods that
do not explicitly deal with this exact type of book.

This way, we can create other types of books and all functionality will be integrated seamlessly without having to
@Override methods and alter code.
*/

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Book implements Readable, Words, Comparable {
    String bookName;
    String bookText;
    String author;
    Genre genre;

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


    @Override
    public void read() {
        System.out.println(this.getBookName() + " by " + this.getAuthor() + "\n"
                + this.getBookText());
    }

    @Override
    public Long countWords() {
        String[] words = this.bookText.split("\\W+");
        return Stream.of(words).collect(Collectors.counting());
    }

    @Override
    public Map<String, Long> wordUse() {
        String[] words = this.bookText.split("\\W+");
        return Stream.of(words)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    @Override
    public int compareTo(Object o) {
        int compare = this.getBookName().compareTo(o.toString());
        return compare;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
