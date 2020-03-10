package ru.itprogram.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Configuration;
import ru.itprogram.model.dto.ApplicantDto;
import ru.itprogram.model.dto.EmailDto;
import ru.itprogram.model.dto.PhoneDto;
import ru.itprogram.model.entity.ApplicantEntity;
import ru.itprogram.model.entity.EmailEntity;
import ru.itprogram.model.entity.PhoneEntity;

@Configuration
public class MapperConfiguration extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(ApplicantEntity.class, ApplicantDto.class)
                .field("profession", "professionDto")
                .field("experience", "experienceDto")
                .field("emails", "emailDtoList")
                .field("phones", "phoneDtoList")
                .byDefault()
                .register();

        factory.classMap(EmailEntity.class, EmailDto.class)
                .field("applicant.id", "applicantId")
                .byDefault()
                .register();

        factory.classMap(PhoneEntity.class, PhoneDto.class)
                .field("applicant.id", "applicantId")
                .byDefault()
                .register();
    }
}
