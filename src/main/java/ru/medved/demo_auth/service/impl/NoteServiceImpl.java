package ru.medved.demo_auth.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.medved.demo_auth.dto.NoteDto;
import ru.medved.demo_auth.entity.NoteEntity;
import ru.medved.demo_auth.enums.ColorNote;
import ru.medved.demo_auth.mapper.NoteMapper;
import ru.medved.demo_auth.repository.NoteRepository;
import ru.medved.demo_auth.service.NoteService;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Override
    public Long addNote(NoteDto dto) {
        NoteEntity entity = noteMapper.toEntity(dto);
        return noteRepository.save(entity).getId();
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    @PreAuthorize("hasAuthority('USER')")
    @Override
    public List<NoteDto> findAll() {
        return List.of(new NoteDto(1L, ColorNote.GREEN, LocalDateTime.now(), "textjopa"));
//        return noteMapper.toDtos(noteRepository.findAll());
    }

    @Override
    public List<NoteDto> findAllByDate(LocalDate date) {
        return noteMapper.toDtos(noteRepository.findAllByCreatedDate(LocalDateTime.of(date, LocalTime.MIN), LocalDateTime.of(date, LocalTime.MAX)));
    }
}
