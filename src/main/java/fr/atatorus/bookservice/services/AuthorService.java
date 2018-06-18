package fr.atatorus.bookservice.services;

import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.atatorus.bookservice.entities.Author;
import fr.atatorus.bookservice.entities.Book;
import fr.atatorus.bookservice.exceptions.AuthorNotFoundException;

@WebService(name = "Author", serviceName = "AuthorService")
public interface AuthorService {

    List<Book>
            getBooksFromAuthor(@WebParam(name = "authorFirstName") String authorFirstName,
                               @WebParam(name = "authorLastName") String authorLastName)
                                                                                        throws AuthorNotFoundException;

    Author getAuthor(@WebParam(name = "authorId") Long id) throws AuthorNotFoundException;

    List<Author>
            getAuthorsByName(@WebParam(name = "firstName") String firstName,
                             @WebParam(name = "authorLastName") String lastName) throws AuthorNotFoundException;

    Long createAuthor(@WebParam(name = "firstName") String firstName,
                      @WebParam(name = "lastName") String lastName,
                      @WebParam(name = "nationality") String nationality,
                      @WebParam(name = "dateOfBirth") Date dateOfBirth,
                      @WebParam(name = "dateOfDeath") Date dateOfDeath);

}
