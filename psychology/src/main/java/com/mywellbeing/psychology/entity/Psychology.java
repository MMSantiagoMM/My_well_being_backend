package com.mywellbeing.psychology.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "psychology")
public class Psychology {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private Integer firstAnswer;
    private Integer secondAnswer;
    private Integer thirdAnswer;

    public Psychology() {
    }

    public Psychology(Long id, Long idUser, Integer firstAnswer, Integer secondAnswer,
                      Integer thirdAnswer) {
        this.id = id;
        this.idUser = idUser;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Integer getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(Integer firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public Integer getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(Integer secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public Integer getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(Integer thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }
}
