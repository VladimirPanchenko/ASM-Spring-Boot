package ru.itprogram.service.impl;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import ru.itprogram.model.dto.ExperienceDto;
import ru.itprogram.model.entity.ExperienceEntity;
import ru.itprogram.repository.ExperienceRepository;
import ru.itprogram.service.ExperienceService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final MapperFacade mapperFacade;

    @Override
    public List<ExperienceDto> getAllExperience() {
        return mapperFacade.mapAsList(experienceRepository.findAll(), ExperienceDto.class);
    }

    @Override
    public ExperienceDto findExperienceById(long id) {
        return mapperFacade.map(experienceRepository.findById(id), ExperienceDto.class);
    }

    @Override
    public void saveNewExperience(ExperienceDto experienceDto) {
        experienceRepository.save(mapperFacade.map(experienceDto, ExperienceEntity.class));
    }

    @Override
    public void updateExperience(ExperienceDto experienceDto) {
        Optional<ExperienceEntity> optionalExperience = experienceRepository.findById(experienceDto.getId());
        optionalExperience
                .ifPresent(experienceEntity -> experienceRepository
                        .save(mapperFacade.map(experienceDto, ExperienceEntity.class)));
    }

    @Override
    public void deleteExperienceById(long id) {
        experienceRepository.deleteById(id);
    }
}
