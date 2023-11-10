package com.example.education.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "education")
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "first_answer")
    private Integer firstAnswer;
    @Column(name = "second_answer")
    private Integer SecondAnswer;
    @Column(name = "third_answer")
    private Integer thirdAnswer;
    @Column(name = "id_user")
    private Long idUser;
}

