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
    @PostMapping
    public ResponseEntity<EducationEntity> create (@RequestBody EducationDto educationDto){
        EducationEntity educationEntity = educationService.create(educationDto);
        return new ResponseEntity<>(educationEntity,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EducationEntity>> geAllAmswers() {
        List<EducationEntity> educations = educationService.showAnswers();
        return new ResponseEntity<>(educations,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(educationService.deleteAnswer(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<EducationEntity> getResponseById(@PathVariable Long id){
        return educationService.GetResponseById(id)
                .map(educationEntity -> new ResponseEntity<>(educationEntity,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EducationEntity> updateAnswer(@PathVariable Long id, @RequestBody EducationDto educationDto){
        return educationService.update(id,educationDto)
                .map(economyEntity -> new ResponseEntity<>(economyEntity,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
