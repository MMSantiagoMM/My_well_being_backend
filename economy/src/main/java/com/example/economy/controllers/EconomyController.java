package com.example.economy.controllers;

import com.example.economy.entity.EconomyEntity;
import com.example.economy.model.EconomyDto;
import com.example.economy.service.EconomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/economy")
public class EconomyController {
    @Autowired
    private EconomyService economyService;
    @PostMapping("/createanswer")
    @ResponseStatus(HttpStatus.CREATED)
    public EconomyDto createAnswer(@RequestBody EconomyDto economyDto){
        return economyService.createAnswer(economyDto);
    }
    @GetMapping("/getbyid/{idEducation}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EconomyEntity checkanswer(@PathVariable Long idEconomy){
        return economyService.GetResponseById(idEconomy);
    }

    @GetMapping("/answers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<EconomyEntity> geAllAmswers() {
        return economyService.showAnswers();
    }

    @DeleteMapping("/eliminar/{idEconomy}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAnswer(@PathVariable Long idEconomy) {
        economyService.DeleteAnswer(idEconomy);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EconomyDto> updateAnswer(@PathVariable Long idEconomy, @RequestBody EconomyDto economyDto){

        economyDto.setIdEconomy(idEconomy);
        EconomyDto answerUpdate = economyService.updateAnswer(economyDto);

        if (answerUpdate != null){
            return new ResponseEntity<>(answerUpdate, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
