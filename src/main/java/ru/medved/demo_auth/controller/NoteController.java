package ru.medved.demo_auth.controller;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.medved.demo_auth.dto.NoteDto;
import ru.medved.demo_auth.service.NoteService;

@RequiredArgsConstructor
@RequestMapping("v1/notes")
@RestController
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/add")
    ResponseEntity<Long> addNote(@RequestBody NoteDto dto){
        return new ResponseEntity<>(noteService.addNote(dto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    HttpStatus deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return HttpStatus.OK;
    }

    @GetMapping("/all")
    ResponseEntity<List<NoteDto>> findAll() {
        return new ResponseEntity<>(noteService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/all", params = "date")
    ResponseEntity<List<NoteDto>> findAllByDate(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate date) {
        return new ResponseEntity<>(noteService.findAllByDate(date), HttpStatus.OK);
    }

}
