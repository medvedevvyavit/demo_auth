package ru.medved.demo_auth.dto;

import java.time.LocalDateTime;
import lombok.Data;
import ru.medved.demo_auth.enums.ColorNote;

@Data
public class NoteDto {

    private Long id;
    private ColorNote colorNote;
    private LocalDateTime createdDate;
    private String textNote;
}
