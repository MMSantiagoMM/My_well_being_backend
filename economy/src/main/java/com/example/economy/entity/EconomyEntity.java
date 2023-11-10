package com.example.economy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="Economy")
public class EconomyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "answer_one")
    private Integer answerOne;
    @Column(name = "answer_two")
    private Integer answerTwo;
    @Column(name = "answer_three")
    private Integer answerThree;
    @Column(name = "id_user")
    private Long idUser;
}
