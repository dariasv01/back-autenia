package com.api.crud.infrastructure.entities;

import com.api.crud.domain.models.Spent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class SpentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private Long idGroud;
    private LocalDateTime creationDate;
    private String description;
    private Float amount;

    public SpentEntity() {}

    public SpentEntity(Long id, Long idUser, Long idGroud, LocalDateTime creationDate, String description, Float amount) {
        this.id = id;
        this.idUser = idUser;
        this.idGroud = idGroud;
        this.creationDate = creationDate;
        this.description = description;
        this.amount = amount;
    }

    public static SpentEntity frimDomainModel(Spent spent){
        return new SpentEntity(spent.getId(),spent.getIdUser(),spent.getIdGroup(),spent.getCreationDate(),spent.getDescription(),spent.getAmount());
    }

    public Spent toDomainModel(){
        return new Spent(id,idUser,idGroud,creationDate,description,amount);
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

    public Long getIdGroud() {
        return idGroud;
    }

    public void setIdGroud(Long idGroud) {
        this.idGroud = idGroud;
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
