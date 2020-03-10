package ru.itprogram.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itprogram.model.dto.EmailDto;

import java.util.List;

@RequestMapping("/")
public interface EmailController {
    @RequestMapping(value = "/emails", method = RequestMethod.GET)
    ResponseEntity<List<EmailDto>> getEmails();

    @RequestMapping(value = "/emails", method = RequestMethod.POST)
    ResponseEntity<HttpStatus> createEmail(@RequestBody EmailDto emailDto);

    @RequestMapping(value = "/emails/{id}", method = RequestMethod.DELETE)
    ResponseEntity<HttpStatus> removeEmailById(@PathVariable Long id);
}
