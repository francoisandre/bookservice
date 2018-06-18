package fr.atatorus.bookservice.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.atatorus.bookservice.entities.Author;
import fr.atatorus.bookservice.entities.Book;
import fr.atatorus.bookservice.entities.BookType;
import fr.atatorus.bookservice.exceptions.BookNotFoundException;

@WebService(name = "Book", serviceName = "BookService")
public interface IBookService {

    Book getBook(@WebParam(name = "bookId") Long id) throws BookNotFoundException;

    List<Book> getBooksByTitle(@WebParam(name = "title") String title);

    List<Author> getAuthorsFromBook(@WebParam(name = "bookTitle") String bookTitle) throws BookNotFoundException;

    Long createBook(@WebParam(name = "title") String title,
                    @WebParam(name = "type") BookType type,
                    @WebParam(name = "year") int year,
                    @WebParam(name = "authorsId") Long... authorsId);

}
