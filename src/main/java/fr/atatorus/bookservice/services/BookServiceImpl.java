package fr.atatorus.bookservice.services;

import static fr.atatorus.bookservice.services.Datas.authors;
import static fr.atatorus.bookservice.services.Datas.books;
import static fr.atatorus.bookservice.services.Datas.getBookId;

import java.util.ArrayList;
import java.util.List;

import fr.atatorus.bookservice.entities.Author;
import fr.atatorus.bookservice.entities.Book;
import fr.atatorus.bookservice.entities.BookType;
import fr.atatorus.bookservice.exceptions.BookNotFoundException;

public class BookServiceImpl implements IBookService {

    @Override
    public Book getBook(Long id) throws BookNotFoundException {
        Book b = books.get(id);
        if (b == null) {
            BookNotFoundException e = new BookNotFoundException();
            e.setId(id);
            throw e;
        }
        return b;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        List<Book> booksToReturn = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().contains(title)) {
                booksToReturn.add(book);
            }
        }
        return booksToReturn;
    }

    @Override
    public List<Author> getAuthorsFromBook(String bookTitle) throws BookNotFoundException {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book.getAuthors();
            }
        }
        BookNotFoundException e = new BookNotFoundException();
        e.setTitle(bookTitle);
        throw e;
    }

    @Override
    public Long createBook(String title, BookType type, int year, Long... authorsId) {
        List<Author> bookAuthors = new ArrayList<>();
        for (Long id : authorsId) {
            bookAuthors.add(authors.get(id));
        }

        Book book = new Book();
        Long id = getBookId();
        book.setId(id);
        book.setTitle(title);
        book.setType(type);
        book.setYear(year);
        book.setAuthors(bookAuthors);

        books.put(book.getId(), book);
        return id;
    }

}
