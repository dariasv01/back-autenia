package com.api.crud.application.usecases.Group;

import com.api.crud.domain.ports.in.Group.DeleteGroupUseCase;
import com.api.crud.domain.ports.in.User.DeleteUserUseCase;
import com.api.crud.domain.ports.out.GroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

public class DeleteGroupUseCaseImpl implements DeleteGroupUseCase {

    private final GroupRepositoryPort groupRepositoryPort;

    public DeleteGroupUseCaseImpl(GroupRepositoryPort groupRepositoryPort) {
        this.groupRepositoryPort = groupRepositoryPort;
    }

    @Override
    public Boolean deleteGroup(Long id) {
        return groupRepositoryPort.deleteById(id);
    }
}
