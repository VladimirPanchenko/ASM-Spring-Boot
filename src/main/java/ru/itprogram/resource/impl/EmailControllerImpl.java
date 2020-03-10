package ru.itprogram.resource.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itprogram.model.dto.EmailDto;
import ru.itprogram.resource.EmailController;
import ru.itprogram.service.EmailService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmailControllerImpl implements EmailController {

    private final EmailService emailService;

    @Override
    public ResponseEntity<List<EmailDto>> getEmails() {
        return ResponseEntity.ok(emailService.getAllEmail());
    }

    @Override
    public ResponseEntity<HttpStatus> createEmail(EmailDto emailDto) {
        emailService.saveNewEmail(emailDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> removeEmailById(Long id) {
        emailService.deleteEmailById(id);
        return ResponseEntity.ok().build();
    }
}
