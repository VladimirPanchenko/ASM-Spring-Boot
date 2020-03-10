package ru.itprogram.service.impl;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import ru.itprogram.model.dto.EmailDto;
import ru.itprogram.model.entity.EmailEntity;
import ru.itprogram.repository.EmailRepository;
import ru.itprogram.service.EmailService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    private final MapperFacade mapperFacade;

    @Override
    public List<EmailDto> getAllEmail() {
        return mapperFacade.mapAsList(emailRepository.findAll(), EmailDto.class);
    }

    @Override
    public List<EmailDto> findEmailsByApplicantId(long id) {
        return mapperFacade.mapAsList(emailRepository.findAllByApplicantId(id), EmailDto.class);
    }

    @Override
    public void saveNewEmail(EmailDto emailDto) {
        emailRepository.save(mapperFacade.map(emailDto, EmailEntity.class));
    }

    @Override
    public void deleteEmailById(long id) {
        emailRepository.deleteById(id);
    }
}
