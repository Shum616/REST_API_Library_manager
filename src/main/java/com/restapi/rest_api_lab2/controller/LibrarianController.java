package com.restapi.rest_api_lab2.controller;

import com.restapi.rest_api_lab2.persistance.entities.Librarian;
import com.restapi.rest_api_lab2.service.dto.LibrarianDTO;
import com.restapi.rest_api_lab2.service.dto.RegisterLibrarianDTO;
import com.restapi.rest_api_lab2.service.interfaces.LibrarianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
    private final LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping("all")
    public List<LibrarianDTO> getAll() {
        return librarianService.getAll().stream().map(LibrarianDTO::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public LibrarianDTO getById(@PathVariable Long id) {
        return new LibrarianDTO(librarianService.findLibrarianById(id));
    }

    @PostMapping
    public List<LibrarianDTO> getLibrarianByName(@RequestBody String name) {
        return librarianService.findLibrarianByName(name).stream().map(LibrarianDTO::new).collect(Collectors.toList());
    }

    @PostMapping("register")
    public LibrarianDTO addLibrarian(@RequestBody RegisterLibrarianDTO registerLibrarianDTO) {
        return new LibrarianDTO(librarianService.saveLibrarian(registerLibrarianDTOToLibrarian(registerLibrarianDTO)));
    }

    @DeleteMapping("{id}")
    public void deleteLibrarian(@PathVariable Long id){
        librarianService.deleteLibrarianById(id);
    }

    private Librarian registerLibrarianDTOToLibrarian(RegisterLibrarianDTO registerLibrarianDTO) {
        return new Librarian(registerLibrarianDTO.getName(),
                registerLibrarianDTO.getSurname(),
                registerLibrarianDTO.getBirthday(),
                registerLibrarianDTO.getPhone());
    }
}
