package com.api.crud.infrastructure.repositories.UserGroup;


import com.api.crud.infrastructure.entities.GroupEntity;
import com.api.crud.infrastructure.entities.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserGroupRepository extends JpaRepository<UserGroupEntity,Long> {
    @Query("select u from UserGroupEntity u where u.idUser = ?1")
    List<UserGroupEntity> findGroupEntitiesByUserId(Long id);
    @Query("select u from UserGroupEntity u where u.idGroup = ?1")
    List<UserGroupEntity> findGroupEntitiesByGroupId(Long id);
}
