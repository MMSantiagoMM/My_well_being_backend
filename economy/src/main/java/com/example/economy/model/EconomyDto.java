package com.example.economy.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EconomyDto {
    private Long id;
    private Integer answerOne;
    private Integer answerTwo;
    private Integer answerThree;
    private Long idUser;
}
