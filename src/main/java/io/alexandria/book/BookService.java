/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.alexandria.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author a153691
 */
@Stateless
public class BookService {

    private List<Book> books;
    
    @PostConstruct
    void init() {
        books = new ArrayList<>();
        books.add(new Book(1, "The Lord of the Rings", "J. R. R. Tolkien"));
        books.add(new Book(2, "A Song of Ice and Fire", "G. R. R. Martin"));
    }

    public Optional<Book> findById(Integer id) {
        return books.stream().filter(b -> Objects.equals(b.getId(), id)).findFirst();
    }

    public List<Book> list() {
        return new ArrayList<>(books);
    }

    public void create(Book book) {
        books.add(book);
    }

    public void update(Book book) {
        for (ListIterator<Book> it = books.listIterator(); it.hasNext();) {
            Book candidate = it.next();
            if (Objects.equals(book.getId(), candidate.getId())) {
                it.set(book);
                break;
            }
        }
    }

    public void delete(Book book) {
        for (Iterator<Book> it = books.iterator(); it.hasNext();) {
            Book candidate = it.next();
            if (Objects.equals(book.getId(), candidate.getId())) {
                it.remove();
                break;
            }
        }
    }

}
