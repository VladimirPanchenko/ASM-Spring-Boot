package ru.itprogram.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itprogram.model.dto.ExperienceDto;

import java.util.List;

@RequestMapping("/")
public interface ExperienceController {
    @RequestMapping(value = "/experiences", method = RequestMethod.GET)
    ResponseEntity<List<ExperienceDto>> getExperiences();

    @RequestMapping(value = "/experiences", method = RequestMethod.POST)
    ResponseEntity<HttpStatus> createExperience(@RequestBody ExperienceDto experienceDto);

    @RequestMapping(value = "/experiences", method = RequestMethod.PUT)
    ResponseEntity<HttpStatus> correctionExperience(@RequestBody ExperienceDto experienceDto);

    @RequestMapping(value = "/experiences/{id}", method = RequestMethod.DELETE)
    ResponseEntity<HttpStatus> removeExperienceById(@PathVariable Long id);
}
