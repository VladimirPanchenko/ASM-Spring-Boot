package ru.itprogram.resource.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itprogram.model.dto.ExperienceDto;
import ru.itprogram.resource.ExperienceController;
import ru.itprogram.service.ExperienceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExperienceControllerImpl implements ExperienceController {

    private final ExperienceService experienceService;

    @Override
    public ResponseEntity<List<ExperienceDto>> getExperiences() {
        return ResponseEntity.ok(experienceService.getAllExperience());
    }

    @Override
    public ResponseEntity<HttpStatus> createExperience(ExperienceDto experienceDto) {
        experienceService.saveNewExperience(experienceDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> correctionExperience(ExperienceDto experienceDto) {
        experienceService.updateExperience(experienceDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> removeExperienceById(Long id) {
        experienceService.deleteExperienceById(id);
        return ResponseEntity.ok().build();
    }
}
