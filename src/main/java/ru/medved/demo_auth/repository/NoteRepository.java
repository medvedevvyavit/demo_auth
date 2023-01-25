package ru.medved.demo_auth.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.medved.demo_auth.entity.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    @Query(
        value = "select note from NoteEntity as note where note.createdDate between :dateMin and :dateMax"
    )
    List<NoteEntity> findAllByCreatedDate(LocalDateTime dateMin, LocalDateTime dateMax);
}
