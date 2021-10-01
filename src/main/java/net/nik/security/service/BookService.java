package net.nik.security.service;

import net.nik.security.domain.Book;
import net.nik.security.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book){
        bookRepository.save(book);
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }
}
