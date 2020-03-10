package ru.itprogram.service.impl;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import ru.itprogram.model.dto.ApplicantDto;
import ru.itprogram.model.entity.ApplicantEntity;
import ru.itprogram.repository.ApplicantRepository;
import ru.itprogram.service.ApplicantService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final MapperFacade mapperFacade;

    @Override
    public List<ApplicantDto> getAllApplicant() {
        return mapperFacade.mapAsList(applicantRepository.findAll(), ApplicantDto.class);
    }

    @Override
    public ApplicantDto findApplicantById(long id) {
        return mapperFacade.map(applicantRepository.findById(id), ApplicantDto.class);
    }

    @Override
    public void saveNewApplicant(ApplicantDto applicantDto) {
        applicantRepository.save(mapperFacade.map(applicantDto, ApplicantEntity.class));
    }

    @Override
    public void updateApplicant(ApplicantDto applicantDto) {
        Optional<ApplicantEntity> optionalApplicant = applicantRepository.findById(applicantDto.getId());
        optionalApplicant
                .ifPresent(applicantEntity -> applicantRepository
                        .save(mapperFacade.map(applicantDto, ApplicantEntity.class)));
    }

    @Override
    public void deleteApplicantById(long id) {
        applicantRepository.deleteById(id);
    }
}
