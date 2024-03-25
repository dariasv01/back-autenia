package com.api.crud.application.usecases.Users;

import com.api.crud.domain.models.User;
import com.api.crud.domain.ports.in.User.UpdateUserUseCase;
import com.api.crud.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> updateUser(User user, Long id) {
        return userRepositoryPort.update(user);
    }
}
