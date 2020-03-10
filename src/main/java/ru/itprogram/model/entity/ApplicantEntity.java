package ru.itprogram.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "asm_applicant")
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(nullable = false)
    private short age;

    @Column(nullable = false)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profession_id")
    private ProfessionEntity profession;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_id")
    private ExperienceEntity experience;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id", referencedColumnName="id")
    private List<EmailEntity> emails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private List<PhoneEntity> phones;

}
