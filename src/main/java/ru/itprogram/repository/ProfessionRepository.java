package ru.itprogram.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itprogram.model.entity.ProfessionEntity;

public interface ProfessionRepository extends CrudRepository<ProfessionEntity, Long> {

}
