package fr.atatorus.bookservice.entities;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Long id;
    private String title;
    private BookType type;
    private int year;
    private List<Author> authors;
    private int note;

    public Book( ) {
        id = null;
        title = null;
        type = null;
        year = 0;
        authors = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
}
