package ru.medved.demo_auth.service;

import java.time.LocalDate;
import java.util.List;
import ru.medved.demo_auth.dto.NoteDto;

public interface NoteService {

    Long addNote(NoteDto dto);
    void deleteNote(Long id);
    List<NoteDto> findAll();
    List<NoteDto> findAllByDate(LocalDate dateMin);
}
