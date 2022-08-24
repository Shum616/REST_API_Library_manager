package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.persistance.entities.Book;
import com.restapi.rest_api_lab2.persistance.entities.Reader;
import com.restapi.rest_api_lab2.persistance.entities.ReadingRoom;
import com.restapi.rest_api_lab2.service.dto.ReadingRoomDTO;
import com.restapi.rest_api_lab2.service.dto.RegisterReadingRoomDTO;
import com.restapi.rest_api_lab2.service.interfaces.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/readingRoom")
public class ReadingRoomController {
    private final BookService bookService;
    private final ReaderService readerService;
    private final ReadingRoomService readingRoomService;

    public ReadingRoomController(BookService bookService, ReaderService readerService, ReadingRoomService readingRoomService){
        this.bookService = bookService;
        this.readerService = readerService;
        this.readingRoomService = readingRoomService;
    }

    @GetMapping("all")
    public List<ReadingRoomDTO> getAll() {
        return readingRoomService.getAll().stream().map(ReadingRoomDTO::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ReadingRoomDTO getById(@PathVariable Long id) {
        return new ReadingRoomDTO(readingRoomService.findReadingRoomById(id));
    }

    @GetMapping("book/{id}")
    public List<ReadingRoomDTO> getReadingRoomByBookId(@PathVariable Long id) {
        return readingRoomService.findReadingRoomByBookId(id).stream().map(ReadingRoomDTO::new).collect(Collectors.toList());
    }

    @GetMapping("reader/{id}")
    public List<ReadingRoomDTO> getReadingRoomByReaderId(@PathVariable Long id) {
        return readingRoomService.findReadingRoomByReaderId(id).stream().map(ReadingRoomDTO::new).collect(Collectors.toList());
    }

    @PostMapping("register")
    public ReadingRoomDTO addReadingRoom(@RequestBody RegisterReadingRoomDTO registerReadingRoomDTO){
        Book book = bookService.findBookById(registerReadingRoomDTO.getBookId());
        Reader reader = readerService.findReaderById(registerReadingRoomDTO.getReaderId());
        return new ReadingRoomDTO(readingRoomService.saveReadingRoom(new ReadingRoom(reader, book)));
    }

    @DeleteMapping("{id}")
    public void deleteReadingRoom(@PathVariable Long id) {
        readingRoomService.deleteReadingRoomById(id);
    }
}
