package com.api.crud.domain.ports.out;

import com.api.crud.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> update(User user);
    boolean deleteById(Long id);

}
