package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.persistance.entities.Book;
import com.restapi.rest_api_lab2.persistance.entities.BookSubscription;
import com.restapi.rest_api_lab2.persistance.entities.Subscription;
import com.restapi.rest_api_lab2.service.dto.BookSubscriptionDTO;
import com.restapi.rest_api_lab2.service.dto.RegisterBookSubscriptionDTO;
import com.restapi.rest_api_lab2.service.interfaces.BookService;
import com.restapi.rest_api_lab2.service.interfaces.BookSubscriptionService;
import com.restapi.rest_api_lab2.service.interfaces.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookSubscription")
public class BookSubscriptionController {
    private final BookService bookService;
    private final SubscriptionService subscriptionService;
    private final BookSubscriptionService bookSubscriptionService;

    public BookSubscriptionController(BookService bookService, SubscriptionService subscriptionService, BookSubscriptionService bookSubscriptionService) {
        this.bookService = bookService;
        this.subscriptionService = subscriptionService;
        this.bookSubscriptionService = bookSubscriptionService;
    }

    @GetMapping("all")
    public List<BookSubscriptionDTO> getAll() {
        return bookSubscriptionService.getAll().stream().map(BookSubscriptionDTO::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public BookSubscriptionDTO getById(@PathVariable Long id) {
        return new BookSubscriptionDTO(bookSubscriptionService.findBookSubscriptionById(id));
    }

    @GetMapping("book/{id}")
    public List<BookSubscriptionDTO> getBookSubscriptionByBookId(@PathVariable Long id) {
        return bookSubscriptionService.findBookSubscriptionByBookId(id).stream().map(BookSubscriptionDTO::new).collect(Collectors.toList());
    }

    @GetMapping("subscription/{id}")
    public List<BookSubscriptionDTO> getBookSubscriptionBySubscriptionId(@PathVariable Long id) {
        return bookSubscriptionService.findBookSubscriptionBySubscriptionId(id).stream().map(BookSubscriptionDTO::new).collect(Collectors.toList());
    }

    @PostMapping("register")
    public BookSubscriptionDTO addBookSubscription(@RequestBody RegisterBookSubscriptionDTO registerBookSubscriptionDTO) {
        Book book = bookService.findBookById(registerBookSubscriptionDTO.getBookId());
        Subscription subscription = subscriptionService.findSubscriptionById(registerBookSubscriptionDTO.getSubscriptionId());
        return new BookSubscriptionDTO(bookSubscriptionService.saveBookSubscription(new BookSubscription(subscription, book)));
    }

    @DeleteMapping("{id}")
    public void deleteBookSubscription(@PathVariable Long id) {
        bookSubscriptionService.deleteBookSubscriptionById(id);
    }
}
