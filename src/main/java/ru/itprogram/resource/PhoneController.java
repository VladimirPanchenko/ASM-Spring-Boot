package ru.itprogram.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itprogram.model.dto.PhoneDto;

import java.util.List;

@RequestMapping("/")
public interface PhoneController {
    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    ResponseEntity<List<PhoneDto>> getPhones();

    @RequestMapping(value = "/phones", method = RequestMethod.POST)
    ResponseEntity<HttpStatus> createPhone(@RequestBody PhoneDto phoneDto);

    @RequestMapping(value = "/phones/{id}", method = RequestMethod.DELETE)
    ResponseEntity<HttpStatus> removePhoneById(@PathVariable Long id);
}
