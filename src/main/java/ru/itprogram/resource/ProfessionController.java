package ru.itprogram.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itprogram.model.dto.ProfessionDto;

import java.util.List;

@RequestMapping("/")
public interface ProfessionController {
    @RequestMapping(value = "/professions", method = RequestMethod.GET)
    ResponseEntity<List<ProfessionDto>> getProfessions();

    @RequestMapping(value = "/professions", method = RequestMethod.POST)
    ResponseEntity<HttpStatus> createProfession(@RequestBody ProfessionDto professionDto);

    @RequestMapping(value = "/professions", method = RequestMethod.PUT)
    ResponseEntity<HttpStatus> correctionProfession(@RequestBody ProfessionDto professionDto);

    @RequestMapping(value = "/professions/{id}", method = RequestMethod.DELETE)
    ResponseEntity<HttpStatus> removeProfessionById(@PathVariable Long id);
}
