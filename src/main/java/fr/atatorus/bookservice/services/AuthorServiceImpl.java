package fr.atatorus.bookservice.services;

import static fr.atatorus.bookservice.services.Datas.authors;
import static fr.atatorus.bookservice.services.Datas.books;
import static fr.atatorus.bookservice.services.Datas.getAuthorId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.atatorus.bookservice.entities.Author;
import fr.atatorus.bookservice.entities.Book;
import fr.atatorus.bookservice.exceptions.AuthorNotFoundException;

public class AuthorServiceImpl implements AuthorService {

    @Override
    public List<Book>
            getBooksFromAuthor(String authorFirstName, String authorLastName) throws AuthorNotFoundException {
        List<Book> booksFromAuthor = new ArrayList<>();
        for (Book book : books.values()) {
            for (Author author : book.getAuthors()) {
                if (authorFirstName.equalsIgnoreCase(author.getFirstName()) && authorLastName.equalsIgnoreCase(author.getLastName())) {
                    booksFromAuthor.add(book);
                }
                break;
            }
        }
        if (booksFromAuthor.isEmpty()) {
            AuthorNotFoundException e = new AuthorNotFoundException();
            e.setAuthor(authorFirstName + " " + authorLastName);
            throw e;
        }
        return booksFromAuthor;
    }

    @Override
    public Author getAuthor(Long id) throws AuthorNotFoundException {
        Author a = authors.get(id);
        if (a == null) {
            AuthorNotFoundException e = new AuthorNotFoundException();
            e.setId(id);
            throw e;
        }
        return a;
    }

    @Override
    public List<Author> getAuthorsByName(String firstName, String lastName) throws AuthorNotFoundException {
        List<Author> authorsToReturn = new ArrayList<>();
        for (Author author : authors.values()) {
            if (author.getFirstName().contains(firstName) || author.getLastName().contains(lastName)) {
                authorsToReturn.add(author);
            }
        }
        return authorsToReturn;
    }

    @Override
    public Long createAuthor(String firstName, String lastName, String nationality, Date dateOfBirth, Date dateOfDeath) {
        Author author = new Author();
        Long authorId = getAuthorId();
        author.setId(authorId);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setNationality(nationality);
        author.setDateOfBirth(dateOfBirth);
        author.setDateOfDeath(dateOfDeath);

        authors.put(author.getId(), author);
        return authorId;
    }

}
