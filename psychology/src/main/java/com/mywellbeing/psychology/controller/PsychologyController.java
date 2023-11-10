package com.mywellbeing.psychology.controller;


import com.mywellbeing.psychology.dto.PsychologyDTO;
import com.mywellbeing.psychology.entity.Psychology;
import com.mywellbeing.psychology.service.PsychologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("psychology")
public class PsychologyController {

    @Autowired
    private PsychologyService service;


    @PostMapping
    public ResponseEntity<Psychology> create (@RequestBody PsychologyDTO psychologyDTO){
        Psychology psychology = service.create(psychologyDTO);
        return new ResponseEntity<>(psychology, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Psychology>> getAll(){
        List<Psychology> psychologies = service.getAll();
        return new ResponseEntity<>(psychologies,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Psychology> getOne(@PathVariable Long id){
        return service.getOne(id)
                .map(psychology -> new ResponseEntity<>(psychology,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Psychology> update (@PathVariable Long id, @RequestBody PsychologyDTO psychologyDTO){
        return service.update(id,psychologyDTO)
                .map(psychology -> new ResponseEntity<>(psychology,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
