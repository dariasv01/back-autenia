package com.api.crud.domain.models;

public class UserGroup {
    private Long id;
    private Long idUser;
    private Long idGroup;

    public UserGroup(Long id, Long idUser, Long idGroup) {
        this.id = id;
        this.idUser = idUser;
        this.idGroup = idGroup;
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

    public void setIdGroup() {
        this.idGroup = idGroup;
    }
}
