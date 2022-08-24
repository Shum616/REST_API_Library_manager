package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.persistance.entities.Reader;
import com.restapi.rest_api_lab2.service.dto.*;
import com.restapi.rest_api_lab2.service.interfaces.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("all")
    public List<ReaderDTO> getAll() {
        return readerService.getAll().stream().map(ReaderDTO::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ReaderDTO getById(@PathVariable Long id) {
        return new ReaderDTO(readerService.findReaderById(id));
    }

    @PostMapping
    public List<ReaderDTO> getReaderByName(@RequestBody String name) {
        return readerService.findReaderByName(name).stream().map(ReaderDTO::new).collect(Collectors.toList());
    }

    @PostMapping("register")
    public ReaderDTO addReader(@RequestBody RegisterReaderDTO registerReaderDTO) {
        return new ReaderDTO(readerService.saveReader(registerReaderDTOToReader(registerReaderDTO)));
    }

    @DeleteMapping("{id}")
    public void deleteReader(@PathVariable Long id){
        readerService.deleteReaderById(id);
    }

    private Reader registerReaderDTOToReader(RegisterReaderDTO registerReaderDTO) {
        return new Reader(registerReaderDTO.getName(),
                registerReaderDTO.getSurname(),
                registerReaderDTO.getBirthday(),
                registerReaderDTO.getPhone());
    }
}
