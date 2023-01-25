package ru.medved.demo_auth.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import ru.medved.demo_auth.dto.NoteDto;
import ru.medved.demo_auth.entity.NoteEntity;

@Mapper
public interface NoteMapper {

    NoteEntity toEntity(NoteDto dto);
    NoteDto toDto(NoteEntity entity);
    List<NoteDto> toDtos(List<NoteEntity> entities);
}
