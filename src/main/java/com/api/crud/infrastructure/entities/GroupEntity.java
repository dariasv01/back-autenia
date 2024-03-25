package com.api.crud.infrastructure.entities;

import com.api.crud.domain.models.Group;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private String nameGroup;
    private Float totalSpent;
    private Integer numberMembers;

    public GroupEntity() {
    }

    public GroupEntity(Long id, Long idUser, String nameGroup, Float totalSpent, Integer numberMembers) {
        this.id = id;
        this.idUser = idUser;
        this.nameGroup = nameGroup;
        this.totalSpent = totalSpent;
        this.numberMembers = numberMembers;
    }

    public static GroupEntity frimDominModel(Group group){
        return new GroupEntity(group.getId(),group.getIdUser(),group.getNameGroup(),group.getTotalSpent(),group.getNumberMembers());
    }

    public Group toDomainModel(){return new Group(id,idUser,nameGroup,totalSpent,numberMembers);}

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

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Float getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Float totalSpent) {
        this.totalSpent = totalSpent;
    }

    public Integer getNumberMembers() {
        return numberMembers;
    }

    public void setNumberMembers(Integer numberMembers) {
        this.numberMembers = numberMembers;
    }
}
