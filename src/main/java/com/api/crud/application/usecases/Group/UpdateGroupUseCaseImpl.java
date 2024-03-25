package com.api.crud.application.usecases.Group;

import com.api.crud.domain.models.Group;
import com.api.crud.domain.models.User;
import com.api.crud.domain.ports.in.Group.UpdateGroupUseCase;
import com.api.crud.domain.ports.in.User.UpdateUserUseCase;
import com.api.crud.domain.ports.out.GroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class UpdateGroupUseCaseImpl implements UpdateGroupUseCase {

    private final GroupRepositoryPort groupRepositoryPort;

    public UpdateGroupUseCaseImpl(GroupRepositoryPort groupRepositoryPort) {
        this.groupRepositoryPort = groupRepositoryPort;
    }

    @Override
    public Optional<Group> updateGroup(Group group, Long id) {
        return groupRepositoryPort.update(group);
    }
}
