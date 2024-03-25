package com.api.crud.domain.ports.in.User;

import com.api.crud.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
}
