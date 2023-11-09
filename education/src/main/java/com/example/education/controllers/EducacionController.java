package com.example.education.controllers;

import com.example.education.entity.EducationEntity;
import com.example.education.model.EducationDto;
import com.example.education.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducacionController {
    @Autowired
    private EducationService educationService;
    @PostMapping("/createanswer")
    @ResponseStatus(HttpStatus.CREATED)
    public EducationDto createAnswer(@RequestBody EducationDto educationDto){
        return educationService.createAnswer(educationDto);
    }

    @GetMapping("/answers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<EducationEntity> geAllAmswers() {
        return educationService.showAnswers();
    }

    @DeleteMapping("/delete/{idEducation}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAnswer(@PathVariable Long idEducation) {
        educationService.deleteAnswer(idEducation);
    }
    @GetMapping("/getbyid/{idEducation}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EducationEntity checkanswer(@PathVariable Long idEducation){
        return educationService.GetResponseById(idEducation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EducationDto> updateAnswer(@PathVariable Long idEducation, @RequestBody EducationDto educationDto){

        educationDto.setIdEducation(idEducation);
        EducationDto answerUpdate = educationService.updateAnswer(educationDto);

        if (answerUpdate != null){
            return new ResponseEntity<>(answerUpdate, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
