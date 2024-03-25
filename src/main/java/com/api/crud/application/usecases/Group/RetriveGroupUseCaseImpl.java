package com.api.crud.application.usecases.Group;

import com.api.crud.domain.models.Group;
import com.api.crud.domain.models.User;
import com.api.crud.domain.ports.in.Group.RetrieveGroupUseCase;
import com.api.crud.domain.ports.in.User.RetrieveUserUseCase;
import com.api.crud.domain.ports.out.GroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriveGroupUseCaseImpl implements RetrieveGroupUseCase {

    private final GroupRepositoryPort groupRepositoryPort;

    public RetriveGroupUseCaseImpl(GroupRepositoryPort groupRepositoryPort) {
        this.groupRepositoryPort = groupRepositoryPort;
    }

    @Override
    public Optional<Group> getGroup(Long id) {
        return groupRepositoryPort.findById(id);
    }

    @Override
    public List<Group> getGroupsByUserId(Long id) {
        return groupRepositoryPort.findByIdUser(id);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepositoryPort.findAll();
    }
}
