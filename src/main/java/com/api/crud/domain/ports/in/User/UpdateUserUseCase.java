package com.api.crud.domain.ports.in.User;

import com.api.crud.domain.models.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(User user, Long id);
}
