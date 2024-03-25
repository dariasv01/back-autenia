package com.api.crud.domain.ports.out;

import com.api.crud.domain.models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepositoryPort {
    Group save(Group group);
    Optional<Group> findById(Long id);
    List<Group> findAll();
    List<Group> findByIdUser(Long id);
    Optional<Group> update(Group group);
    boolean deleteById(Long id);
}
