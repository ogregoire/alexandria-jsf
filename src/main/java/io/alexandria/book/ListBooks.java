/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.alexandria.book;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author a153691
 */
@Named(value = "listBooks")
@RequestScoped
public class ListBooks {

    private List<Book> books;

    @EJB
    BookService bookService;

    /**
     * Creates a new instance of ViewLibrary
     */
    public ListBooks() {
    }

    @PostConstruct
    public void init() {
        books = bookService.list();
    }

    public List<Book> getBooks() {
        return books;
    }
}
