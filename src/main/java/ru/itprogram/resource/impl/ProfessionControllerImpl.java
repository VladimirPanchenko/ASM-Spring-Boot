package ru.itprogram.resource.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itprogram.model.dto.ProfessionDto;
import ru.itprogram.resource.ProfessionController;
import ru.itprogram.service.ProfessionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProfessionControllerImpl implements ProfessionController {

    private final ProfessionService professionService;

    @Override
    public ResponseEntity<List<ProfessionDto>> getProfessions() {
        return ResponseEntity.ok(professionService.getAllProfession());
    }

    @Override
    public ResponseEntity<HttpStatus> createProfession(ProfessionDto professionDto) {
        professionService.saveNewProfession(professionDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> correctionProfession(ProfessionDto professionDto) {
        professionService.updateProfession(professionDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<HttpStatus> removeProfessionById(Long id) {
        professionService.deleteProfessionById(id);
        return ResponseEntity.ok().build();
    }
}
