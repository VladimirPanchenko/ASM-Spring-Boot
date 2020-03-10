package ru.itprogram.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itprogram.model.entity.ApplicantEntity;

public interface ApplicantRepository extends CrudRepository<ApplicantEntity, Long> {
}
