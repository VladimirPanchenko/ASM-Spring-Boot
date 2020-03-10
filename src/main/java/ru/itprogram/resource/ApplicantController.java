package ru.itprogram.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itprogram.model.dto.ApplicantDto;

import java.util.List;

@RequestMapping("/")
public interface ApplicantController {
    @RequestMapping(value = "/applicants", method = RequestMethod.GET)
    ResponseEntity<List<ApplicantDto>> getApplicants();

    @RequestMapping(value = "/applicants", method = RequestMethod.POST)
    ResponseEntity<HttpStatus> createApplicant(@RequestBody ApplicantDto applicantDto);

    @RequestMapping(value = "/applicants", method = RequestMethod.PUT)
    ResponseEntity<HttpStatus> correctionApplicant(@RequestBody ApplicantDto applicantDto);

    @RequestMapping(value = "/applicants/{id}", method = RequestMethod.DELETE)
    ResponseEntity<HttpStatus> removeApplicantById(@PathVariable Long id);
}
