package ru.itprogram.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itprogram.model.entity.Gender;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDto {
    private long id;
    private String name;
    private String surname;
    private String middleName;
    private short age;
    private Gender gender;
    private ProfessionDto professionDto;
    private ExperienceDto experienceDto;
    private List<EmailDto> emailDtoList;
    private List<PhoneDto> phoneDtoList;
}
