package com.api.crud.domain.ports.out;

import com.api.crud.domain.models.UserGroup;

import java.util.List;
import java.util.Optional;

public interface UserGroupRepositoryPort {
    UserGroup save(UserGroup userGroup);
    Optional<UserGroup> findById(Long id);
    List<UserGroup> findAll();
    List<UserGroup> findByGroupId(Long id);
    List<UserGroup> findByUserId(Long id);
    Optional<UserGroup> update(UserGroup userGroup);
    boolean deleteById(Long id);
}
