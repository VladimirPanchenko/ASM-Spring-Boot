package ru.itprogram.service.impl;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import ru.itprogram.model.dto.ProfessionDto;
import ru.itprogram.model.entity.ProfessionEntity;
import ru.itprogram.repository.ProfessionRepository;
import ru.itprogram.service.ProfessionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {

    private final ProfessionRepository professionRepository;
    private final MapperFacade mapperFacade;

    @Override
    public List<ProfessionDto> getAllProfession() {
        return mapperFacade.mapAsList(professionRepository.findAll(), ProfessionDto.class);
    }

    @Override
    public ProfessionDto findProfessionById(long id) {
        return mapperFacade.map(professionRepository.findById(id), ProfessionDto.class);
    }

    @Override
    public void saveNewProfession(ProfessionDto professionDto) {
        professionRepository.save(mapperFacade.map(professionDto, ProfessionEntity.class));
    }

    @Override
    public void updateProfession(ProfessionDto professionDto) {
        Optional<ProfessionEntity> optionalProfession = professionRepository.findById(professionDto.getId());
        optionalProfession
                .ifPresent(professionEntity -> professionRepository
                        .save(mapperFacade.map(professionDto, ProfessionEntity.class)));
    }

    @Override
    public void deleteProfessionById(long id) {
        professionRepository.deleteById(id);
    }
}
