package ru.itprogram.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itprogram.model.entity.PhoneEntity;

import java.util.List;

public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {
    List<PhoneEntity> findAllByApplicantId(Long id);
}
