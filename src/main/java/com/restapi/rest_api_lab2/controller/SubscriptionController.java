package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.persistance.entities.*;
import com.restapi.rest_api_lab2.service.dto.RegisterSubscriptionDTO;
import com.restapi.rest_api_lab2.service.dto.SubscriptionDTO;
import com.restapi.rest_api_lab2.service.interfaces.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    private final ReaderService readerService;
    private final LibrarianService librarianService;
    private final SubscriptionService subscriptionService;

    public SubscriptionController(ReaderService readerService, LibrarianService librarianService, SubscriptionService subscriptionService) {
        this.readerService = readerService;
        this.librarianService = librarianService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("all")
    public List<SubscriptionDTO> getAll() {
        return subscriptionService.getAll().stream().map(SubscriptionDTO::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public SubscriptionDTO getById(@PathVariable Long id) {
        return new SubscriptionDTO(subscriptionService.findSubscriptionById(id));
    }

    @GetMapping("reader/{id}")
    public List<SubscriptionDTO> getSubscriptionByReaderId(@PathVariable Long id) {
        return subscriptionService.findSubscriptionByReaderId(id).stream().map(SubscriptionDTO::new).collect(Collectors.toList());
    }

    @GetMapping("librarian/{id}")
    public List<SubscriptionDTO> getSubscriptionByLibrarianId(@PathVariable Long id) {
        return subscriptionService.findSubscriptionByLibrarianId(id).stream().map(SubscriptionDTO::new).collect(Collectors.toList());
    }

    @PostMapping("register")
    public SubscriptionDTO addSubscription(@RequestBody RegisterSubscriptionDTO registerSubscriptionDTO) {
        Reader reader = readerService.findReaderById(registerSubscriptionDTO.getReaderId());
        Librarian librarian = librarianService.findLibrarianById(registerSubscriptionDTO.getLibrarianId());
        LocalDate wasGiven = registerSubscriptionDTO.getWasGiven();
        LocalDate willBeTaken = registerSubscriptionDTO.getWillBeTaken();
        return new SubscriptionDTO(subscriptionService.saveSubscription(new Subscription(reader,librarian, wasGiven, willBeTaken)));
    }

    @DeleteMapping("{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscriptionById(id);
    }

}
