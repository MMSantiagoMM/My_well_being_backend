package com.example.education.service;

import com.example.education.entity.EducationEntity;
import com.example.education.model.EducationDto;
import com.example.education.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    public EducationDto createAnswer(EducationDto educationDto){
        EducationEntity educationEntity = new EducationEntity();

        educationEntity.setAnswerOne(educationDto.getAnswerOne());
        educationEntity.setAnswerTwo(educationDto.getAnswerTwo());
        educationEntity.setAnswerThree(educationDto.getAnswerThree());
        educationEntity.setIdUser(educationDto.getIdUser());
        educationRepository.save(educationEntity);
        return educationDto;
    }

    public EducationDto updateAnswer( EducationDto educationDto){
        Optional<EducationEntity> answerOptional = educationRepository.findById(educationDto.getIdEducation());

        if (answerOptional.isPresent()){
            EducationEntity educationEntity = new EducationEntity();

            educationEntity.setAnswerOne(educationDto.getAnswerOne());
            educationEntity.setAnswerTwo(educationDto.getAnswerTwo());
            educationEntity.setAnswerThree(educationDto.getAnswerThree());
            educationEntity.setIdUser(educationDto.getIdUser());
            educationRepository.save(educationEntity);
        }return educationDto;
    }
    public List<EducationEntity> showAnswers(){
        return  educationRepository.findAll();
    }

    public EducationEntity GetResponseById(Long idEducation) {
        return educationRepository.findById(idEducation).orElse(null);
    }

    public void deleteAnswer(Long idEducation) {
        educationRepository.existsById(idEducation);
        educationRepository.deleteById(idEducation);
    }
}
