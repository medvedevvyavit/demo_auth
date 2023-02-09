package ru.medved.demo_auth.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.medved.demo_auth.enums.ColorNote;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

    private Long id;
    private ColorNote colorNote;
    private LocalDateTime createdDate;
    private String textNote;
}
