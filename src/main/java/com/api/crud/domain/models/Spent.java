package com.api.crud.domain.models;

import java.time.LocalDateTime;

public class Spent {
    private Long id;
    private Long idUser;
    private Long idGroup;
    private LocalDateTime creationDate;
    private String description;
    private Float amount;

    public Spent(Long id, Long idUser, Long idGroup, LocalDateTime creationDate, String description, Float amount) {
        this.id = id;
        this.idUser = idUser;
        this.idGroup = idGroup;
        this.creationDate = creationDate;
        this.description = description;
        this.amount = amount;
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

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
