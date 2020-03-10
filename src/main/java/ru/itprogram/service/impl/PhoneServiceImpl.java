package ru.itprogram.service.impl;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import ru.itprogram.model.dto.PhoneDto;
import ru.itprogram.model.entity.PhoneEntity;
import ru.itprogram.repository.PhoneRepository;
import ru.itprogram.service.PhoneService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final MapperFacade mapperFacade;

    @Override
    public List<PhoneDto> getAllPhone() {
        return mapperFacade.mapAsList(phoneRepository.findAll(), PhoneDto.class);
    }

    @Override
    public List<PhoneDto> findPhonesByApplicantId(long id) {
        return mapperFacade.mapAsList(phoneRepository.findAllByApplicantId(id), PhoneDto.class);
    }

    @Override
    public void saveNewPhone(PhoneDto phoneDto) {
        phoneRepository.save(mapperFacade.map(phoneDto, PhoneEntity.class));
    }

    @Override
    public void deletePhoneById(long id) {
        phoneRepository.deleteById(id);
    }
}
