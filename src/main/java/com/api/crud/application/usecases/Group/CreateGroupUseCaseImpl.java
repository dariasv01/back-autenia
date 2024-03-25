package com.api.crud.application.usecases.Group;

import com.api.crud.domain.models.Group;
import com.api.crud.domain.models.User;
import com.api.crud.domain.ports.in.Group.CreateGroupUseCase;
import com.api.crud.domain.ports.in.User.CreateUserUseCase;
import com.api.crud.domain.ports.out.GroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

public class CreateGroupUseCaseImpl implements CreateGroupUseCase {

    private final GroupRepositoryPort groupRepositoryPort;

    public CreateGroupUseCaseImpl(GroupRepositoryPort groupRepositoryPort) {
        this.groupRepositoryPort = groupRepositoryPort;
    }

    @Override
    public Group createGroup(Group group) {
        return groupRepositoryPort.save(group);
    }
}
