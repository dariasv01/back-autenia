package com.api.crud.application.usecases.Users;

import com.api.crud.domain.models.User;
import com.api.crud.domain.ports.in.User.RetrieveUserUseCase;
import com.api.crud.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RetriveUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }
}
