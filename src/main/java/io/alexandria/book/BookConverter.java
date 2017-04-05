/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.alexandria.book;

import java.util.Optional;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author a153691
 */
@Named(value = "bookConverter")
@RequestScoped
public class BookConverter implements Converter {

    @EJB
    BookService bookService;
    
    /**
     * Creates a new instance of BookConverter
     */
    public BookConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null ||value.isEmpty()) {
            return null;
        }
        
        try {
            Integer id = Integer.valueOf(value);
            return bookService.findById(id).orElseThrow(()-> new ConverterException("No book exists with ID: " + id));
        } catch (NumberFormatException e) {
            throw new ConverterException("The value is not a valid Book ID:" + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Book) {
            Integer id = ((Book)value).getId();
            return (id != null) ? String.valueOf(id) : null;
        } else {
            throw new ConverterException("The value is not a valid Book instance: " + value);
        }
    }
    
    
    
    
}
