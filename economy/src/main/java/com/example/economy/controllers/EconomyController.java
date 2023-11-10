package com.example.economy.controllers;

import com.example.economy.entity.EconomyEntity;
import com.example.economy.dto.EconomyDto;
import com.example.economy.service.EconomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("economy")
public class EconomyController {

    @Autowired
    private EconomyService economyService;


    @PostMapping
    public ResponseEntity<EconomyEntity> create (@RequestBody EconomyDto economyDto){
        EconomyEntity economyEntity = economyService.create(economyDto);
        return new ResponseEntity<>(economyEntity,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EconomyEntity>> geAllAnswers() {
        List<EconomyEntity> economies = economyService.showAnswers();
        return new ResponseEntity<>(economies,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EconomyEntity> getResponseById(@PathVariable Long id){
        return economyService.GetResponseById(id)
                .map(economyEntity -> new ResponseEntity<>(economyEntity,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(economyService.DeleteAnswer(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<EconomyEntity> updateAnswer(@PathVariable Long id, @RequestBody EconomyDto economyDto){
        return economyService.update(id,economyDto)
                .map(economyEntity -> new ResponseEntity<>(economyEntity,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
