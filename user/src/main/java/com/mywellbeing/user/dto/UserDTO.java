package com.mywellbeing.user.dto;

public class UserDTO {
    private String name;
    private String document;
    private String telephone;
    private String status;
    private String gender;
    private Integer age;
    private String homeRole;
    private Boolean isWorking;
    private Boolean hasChildren;
    private String city;
    private Integer socialCategory;

    public UserDTO() {
    }

    public UserDTO(String name, String document, String telephone, String status, String gender,
                   Integer age, String homeRole, Boolean isWorking, Boolean hasChildren,
                   String city, Integer socialCategory) {
        this.name = name;
        this.document = document;
        this.telephone = telephone;
        this.status = status;
        this.gender = gender;
        this.age = age;
        this.homeRole = homeRole;
        this.isWorking = isWorking;
        this.hasChildren = hasChildren;
        this.city = city;
        this.socialCategory = socialCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHomeRole() {
        return homeRole;
    }

    public void setHomeRole(String homeRole) {
        this.homeRole = homeRole;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSocialCategory() {
        return socialCategory;
    }

    public void setSocialCategory(Integer socialCategory) {
        this.socialCategory = socialCategory;
    }
}
