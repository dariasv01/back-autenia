package com.api.crud.application.usecases.Users;

import com.api.crud.domain.ports.in.Spent.DeleteSpentUseCase;
import com.api.crud.domain.ports.in.User.DeleteUserUseCase;
import com.api.crud.domain.ports.out.SpentRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userRepositoryPort.deleteById(id);
    }
}
