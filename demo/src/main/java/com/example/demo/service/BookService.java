package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repositroy.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book create(Book book) {
        Book createdBook = repository.save(book);
        return createdBook;
    }

    public Book findById(Long id){
        Book foundBook = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
        return foundBook;
    };

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book update(Long id, Book book){
        Book updatedBook = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));

        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());

        return repository.save(updatedBook);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
