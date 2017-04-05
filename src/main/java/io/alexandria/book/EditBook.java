/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.alexandria.book;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author a153691
 */
@Named(value = "editBook")
@ViewScoped
public class EditBook implements Serializable {

    private Book book;

    @EJB
    private BookService bookService;

    /**
     * Creates a new instance of EditBook
     */
    public EditBook() {
    }

    public String save() {
        bookService.update(book);
        return "/books/list?faces-redirect=true";
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
