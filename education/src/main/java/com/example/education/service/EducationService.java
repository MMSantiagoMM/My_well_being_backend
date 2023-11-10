package com.example.education.service;

import com.example.education.entity.EducationEntity;
import com.example.education.exceptions.EducationNotFoundException;
import com.example.education.dto.EducationDto;
import com.example.education.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    public List<EducationEntity> showAnswers(){
        return  educationRepository.findAll();
    }

    public Optional<EducationEntity> GetResponseById(Long id) {
        return Optional.ofNullable(educationRepository.findById(id))
                .orElseThrow( () -> new EducationNotFoundException(id) );
    }

    public EducationEntity create(EducationDto educationDto){
        EducationEntity educationEntity = new EducationEntity();
        educationEntity.setAnswerOne(educationDto.getAnswerOne());
        educationEntity.setAnswerTwo(educationDto.getAnswerTwo());
        educationEntity.setAnswerThree(educationDto.getAnswerThree());
        educationEntity.setIdUser(educationDto.getIdUser());
        educationRepository.save(educationEntity);
        return educationRepository.save(educationEntity);
    }
    public Optional<EducationEntity> update(Long id ,EducationDto educationDto) {
        return Optional.ofNullable(educationRepository.findById(id)
                .map(educationEntity -> {
                    educationEntity.setAnswerOne(educationDto.getAnswerOne());
                    educationEntity.setAnswerTwo(educationDto.getAnswerTwo());
                    educationEntity.setAnswerThree(educationDto.getAnswerThree());
                    educationEntity.setIdUser(educationDto.getIdUser());
                    return educationRepository.save(educationEntity);
                })
                .orElseThrow(() -> new EducationNotFoundException(id)));
    }

    public Boolean deleteAnswer(Long id) {
        if (educationRepository.findById(id).isPresent()){
            educationRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
