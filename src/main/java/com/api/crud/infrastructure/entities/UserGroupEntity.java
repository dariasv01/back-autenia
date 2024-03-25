package com.api.crud.infrastructure.entities;

import com.api.crud.domain.models.User;
import com.api.crud.domain.models.UserGroup;
import jakarta.persistence.*;

@Entity
@Table(name = "user_group_entity", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_group", "id_user"})
})
public class UserGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private Long idGroup;

    public UserGroupEntity(Long id, Long idUser, Long idGroup) {
        this.id = id;
        this.idUser = idUser;
        this.idGroup = idGroup;
    }

    public UserGroupEntity() { }

    public static UserGroupEntity frimDomainModel(UserGroup userGroup){
        return new UserGroupEntity(userGroup.getId(),userGroup.getIdUser(),userGroup.getIdGroup());
    }

    public UserGroup toDomainModel() {return new UserGroup(id,idUser,idGroup);}

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


}
