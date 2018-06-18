package fr.atatorus.bookservice.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.atatorus.bookservice.entities.Author;
import fr.atatorus.bookservice.entities.Book;
import fr.atatorus.bookservice.entities.BookType;

public class Datas {

    public static final Map<Long, Book> books;
    public static final Map<Long, Author> authors;

    private static Long bookId = 0L;
    private static Long authorId = 0L;

    public static Long getBookId() {
        return bookId++ ;
    }

    public static Long getAuthorId() {
        return authorId++ ;
    }

    static {

        books = new HashMap<Long, Book>();
        authors = new HashMap<Long, Author>();

        Book b = new Book();
        Author a = new Author();
        b.setId(getBookId());
        b.setTitle("Emphyrio");
        b.setNote(50);
        b.setYear(1969);
        b.setType(BookType.SCIENCE_FICTION);
        a.setId(getAuthorId());
        a.setFirstName("Jack");
        a.setLastName("Vance");
        a.setDateOfBirth(new Date(1916, 8, 28));
        a.setNationality("Américain");
        b.getAuthors().add(a);
        books.put(b.getId(), b);
        authors.put(a.getId(), a);

        b = new Book();
        b.setId(getBookId());
        b.setNote(50);
        b.setTitle("Le jardin vert de Suldrun");
        b.setType(BookType.ROMANCE);
        b.setYear(1983);
        b.getAuthors().add(a);
        books.put(b.getId(), b);

        b = new Book();
        b.setId(getBookId());
        b.setNote(50);
        b.setTitle("La perle verte");
        b.setType(BookType.HEROIC_FANTASY);
        b.setYear(1986);
        b.getAuthors().add(a);
        books.put(b.getId(), b);

        b = new Book();
        b.setId(getBookId());
        b.setNote(50);
        b.setTitle("Madouc");
        b.setType(BookType.HEROIC_FANTASY);
        b.setYear(1989);
        b.getAuthors().add(a);
        books.put(b.getId(), b);

        b = new Book();
        b.setId(getBookId());
        b.setNote(50);
        b.setTitle("Gloriana ou la reine inassouvie");
        b.setYear(1978);
        b.setType(BookType.HEROIC_FANTASY);
        a = new Author();
        a.setId(getAuthorId());
        a.setFirstName("Michael");
        a.setLastName("Moorcock");
        a.setDateOfBirth(new Date(1939, 12, 18));
        a.setNationality("Anglais");
        b.getAuthors().add(a);
        books.put(b.getId(), b);
        authors.put(a.getId(), a);

        b = new Book();
        b.setId(getBookId());
        b.setNote(50);
        b.setTitle("Étoiles mourantes");
        b.setType(BookType.SCIENCE_FICTION);
        b.setYear(1999);
        a = new Author();
        a.setId(getAuthorId());
        a.setFirstName("Jean Claude");
        a.setLastName("Dunyach");
        a.setNationality("Français");
        a.setDateOfBirth(new Date(1957, 7, 17));
        b.getAuthors().add(a);
        authors.put(a.getId(), a);
        books.put(b.getId(), b);
        a = new Author();
        a.setId(getAuthorId());
        a.setFirstName("");
        a.setLastName("Ayerdhal");
        a.setNationality("Français");
        a.setDateOfBirth(new Date(1959, 1, 26));
        b.getAuthors().add(a);
        authors.put(a.getId(), a);
    }

}
