package ru.itprogram.resource.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itprogram.model.dto.ApplicantDto;
import ru.itprogram.resource.ApplicantController;
import ru.itprogram.service.ApplicantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApplicantControllerImpl implements ApplicantController {

    private final ApplicantService applicantService;

    @Override
    public ResponseEntity<List<ApplicantDto>> getApplicants() {
        return ResponseEntity.ok(applicantService.getAllApplicant());
    }

    @Override
    public ResponseEntity<HttpStatus> createApplicant(ApplicantDto applicantDto) {
        applicantService.saveNewApplicant(applicantDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> correctionApplicant(ApplicantDto applicantDto) {
        applicantService.updateApplicant(applicantDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> removeApplicantById(Long id) {
        applicantService.deleteApplicantById(id);
        return ResponseEntity.ok().build();
    }
}
