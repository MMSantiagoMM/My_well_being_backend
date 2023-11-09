package com.mywellbeing.psychology.service;


import com.mywellbeing.psychology.dto.PsychologyDTO;
import com.mywellbeing.psychology.entity.Psychology;
import com.mywellbeing.psychology.exceptions.PsychologyNotFoundException;
import com.mywellbeing.psychology.repository.PsychologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PsychologyService {


    @Autowired
    private PsychologyRepository repository;

    public List<Psychology> getAll() {
        return repository.findAll();
    }

    public Optional<Psychology> getOne(Long id) {
        return Optional.of(repository.findById(id))
                .orElseThrow(() -> new PsychologyNotFoundException(id));
    }

    public Psychology create(PsychologyDTO psychologyDTO) {
        Psychology psychology = new Psychology();
        psychology.setIdUser(psychologyDTO.getIdUser());
        psychology.setFirstAnswer(psychologyDTO.getFirstAnswer());
        psychology.setSecondAnswer(psychologyDTO.getSecondAnswer());
        psychology.setThirdAnswer(psychologyDTO.getThirdAnswer());
        return repository.save(psychology);
    }

    public Optional<Psychology> update(Long id, PsychologyDTO psychologyDTO) {
        return Optional.ofNullable(repository.findById(id)
                .map(psychology -> {
                    psychology.setIdUser(psychologyDTO.getIdUser());
                    psychology.setFirstAnswer(psychologyDTO.getFirstAnswer());
                    psychology.setSecondAnswer(psychologyDTO.getSecondAnswer());
                    psychology.setThirdAnswer(psychologyDTO.getThirdAnswer());
                    return repository.save(psychology);
                })
                .orElseThrow(() -> new PsychologyNotFoundException(id)));
    }

    public Boolean delete (Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
