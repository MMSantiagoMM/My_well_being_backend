package com.mywellbeing.psychology.dto;

public class PsychologyDTO {

    private Long idUser;
    private Integer firstAnswer;
    private Integer secondAnswer;
    private Integer thirdAnswer;

    public PsychologyDTO(Long idUser, Integer firstAnswer, Integer secondAnswer, Integer thirdAnswer) {
        this.idUser = idUser;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
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
