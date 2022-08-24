package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.persistance.entities.Book;
import com.restapi.rest_api_lab2.service.dto.BookDTO;
import com.restapi.rest_api_lab2.service.dto.RegisterBookDTO;
import com.restapi.rest_api_lab2.service.interfaces.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("all")
    public List<BookDTO> getAll() {
        return bookService.getAll().stream().map(BookDTO::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public BookDTO getById(@PathVariable Long id) {
        return new BookDTO(bookService.findBookById(id));
    }

    @PostMapping
    public List<BookDTO> getBookByName(@RequestBody String name) {
        return bookService.findBookByName(name).stream().map(BookDTO::new).collect(Collectors.toList());
    }

//    @PostMapping
//    public List<BookDTO> getBookByAuthor(@RequestBody String author) {
//        return bookService.findBookByAuthor(author).stream().map(BookDTO::new).collect(Collectors.toList());
//    }
//
//    @PostMapping
//    public List<BookDTO> getBookByPublisher(@RequestBody String publisher) {
//        return bookService.findBookByPublisher(publisher).stream().map(BookDTO::new).collect(Collectors.toList());
//    }

    @PostMapping("register")
    public BookDTO addBook(@RequestBody RegisterBookDTO registerBookDTO) {
        return new BookDTO(bookService.saveBook(registerBookDTOToBook(registerBookDTO)));
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }

    private Book registerBookDTOToBook(RegisterBookDTO registerBookDTO) {
        return new Book(registerBookDTO.getName(),
                registerBookDTO.getAuthor(),
                registerBookDTO.getPublisher(),
                registerBookDTO.getDateOfPublication());
    }
}
