package ru.itprogram.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itprogram.model.entity.EmailEntity;

import java.util.List;

public interface EmailRepository extends CrudRepository<EmailEntity, Long> {
    List<EmailEntity> findAllByApplicantId(Long id);
}
