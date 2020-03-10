package ru.itprogram.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itprogram.model.entity.ExperienceEntity;

public interface ExperienceRepository extends CrudRepository<ExperienceEntity, Long> {
}
