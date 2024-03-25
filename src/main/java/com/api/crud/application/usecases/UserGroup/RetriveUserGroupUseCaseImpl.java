package com.api.crud.application.usecases.UserGroup;

import com.api.crud.domain.models.User;
import com.api.crud.domain.models.UserGroup;
import com.api.crud.domain.ports.in.User.RetrieveUserUseCase;
import com.api.crud.domain.ports.in.UserGroup.RetrieveUserGroupUseCase;
import com.api.crud.domain.ports.out.UserGroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriveUserGroupUseCaseImpl implements RetrieveUserGroupUseCase {

    private final UserGroupRepositoryPort userGroupRepositoryPort;

    public RetriveUserGroupUseCaseImpl(UserGroupRepositoryPort userGroupRepositoryPort) {
        this.userGroupRepositoryPort = userGroupRepositoryPort;
    }

    @Override
    public Optional<UserGroup> getUserGroup(Long id) {
        return userGroupRepositoryPort.findById(id);
    }

    @Override
    public List<UserGroup> getAllUsersGroups() {
        return userGroupRepositoryPort.findAll();
    }

    @Override
    public List<UserGroup> getAllUser(Long idGroup) {
        return userGroupRepositoryPort.findByGroupId(idGroup);
    }

    @Override
    public List<UserGroup> getAllGroup(Long idUser) {
        return userGroupRepositoryPort.findByUserId(idUser);
    }
}
