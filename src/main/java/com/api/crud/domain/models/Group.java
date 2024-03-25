package com.api.crud.domain.models;

public class Group {
    private Long id;
    private Long idUser;
    private String nameGroup;
    private Float totalSpent;
    private Integer numberMembers;

    public Group(Long id, Long idUser, String nameGroup, Float totalSpent, Integer numberMembers) {
        this.id = id;
        this.idUser = idUser;
        this.nameGroup = nameGroup;
        this.totalSpent = totalSpent;
        this.numberMembers = numberMembers;
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
