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
    @Column(name = "first_answer")
    private Integer firstAnswer;
    @Column(name = "second_answer")
    private Integer secondAnswer;
    @Column(name = "third_answer")
    private Integer thirdAnswer;
    @Column(name = "id_user")
    private Long idUser;
}
