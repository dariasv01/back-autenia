package com.api.crud.infrastructure.repositories.Group;

import com.api.crud.domain.models.Group;
import com.api.crud.infrastructure.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaGroupRepository extends JpaRepository<GroupEntity,Long> {
    @Query("select u from GroupEntity u where u.idUser = ?1")
    List<Group> findByIdUser(Long id);
}
