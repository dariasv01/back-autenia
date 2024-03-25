package com.api.crud.infrastructure.repositories.Spent;

import com.api.crud.infrastructure.entities.SpentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSpentRepository extends JpaRepository<SpentEntity, Long> {
    @Query("select u from SpentEntity u where u.idGroud = ?1 order by u.creationDate desc")
    List<SpentEntity> findByIdGroup(Long id);

    @Query("select u from SpentEntity u where u.idGroud = ?1 and u.idUser = ?2")
    List<SpentEntity> findByIdGroupAndIdUser(Long idGroup, Long idUser);
}
