package com.example.economy.service;

import com.example.economy.entity.EconomyEntity;
import com.example.economy.model.EconomyDto;
import com.example.economy.repository.EconomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EconomyService {
    @Autowired
    EconomyRepository economyRepository;

    public EconomyDto createAnswer(EconomyDto economyDto){
        EconomyEntity economyEntity = new EconomyEntity();

        economyEntity.setAnswerOne(economyDto.getAnswerOne());
        economyEntity.setAnswerTwo(economyDto.getAnswerTwo());
        economyEntity.setAnswerThree(economyDto.getAnswerThree());
        economyEntity.setIdUser(economyDto.getIdUser());
        economyRepository.save(economyEntity);
        return economyDto;
    }
    public EconomyDto updateAnswer(EconomyDto economyDto){
        Optional<EconomyEntity> answerOptional = economyRepository.findById(economyDto.getIdEconomy());

        if (answerOptional.isPresent()){
            EconomyEntity economyEntity = new EconomyEntity();

            economyEntity.setAnswerOne(economyDto.getAnswerOne());
            economyEntity.setAnswerTwo(economyDto.getAnswerTwo());
            economyEntity.setAnswerThree(economyDto.getAnswerThree());
            economyEntity.setIdUser(economyDto.getIdUser());
            economyRepository.save(economyEntity);
        }return economyDto;
    }
    public List<EconomyEntity> showAnswers(){
        return  economyRepository.findAll();
    }

    public EconomyEntity GetResponseById(Long idEconomy) {
        return economyRepository.findById(idEconomy).orElse(null);
    }

    public void DeleteAnswer(Long idEconomy) {
        economyRepository.existsById(idEconomy);
        economyRepository.deleteById(idEconomy);
    }


}
