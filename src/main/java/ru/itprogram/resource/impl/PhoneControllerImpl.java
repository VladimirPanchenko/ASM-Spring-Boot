package ru.itprogram.resource.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itprogram.model.dto.PhoneDto;
import ru.itprogram.resource.PhoneController;
import ru.itprogram.service.PhoneService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PhoneControllerImpl implements PhoneController {

    private final PhoneService phoneService;

    @Override
    public ResponseEntity<List<PhoneDto>> getPhones() {
        return ResponseEntity.ok(phoneService.getAllPhone());
    }

    @Override
    public ResponseEntity<HttpStatus> createPhone(PhoneDto phoneDto) {
        phoneService.saveNewPhone(phoneDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> removePhoneById(Long id) {
        phoneService.deletePhoneById(id);
        return ResponseEntity.ok().build();
    }
}
