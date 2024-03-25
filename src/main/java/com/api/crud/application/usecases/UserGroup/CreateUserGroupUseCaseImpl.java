package com.api.crud.application.usecases.UserGroup;

import com.api.crud.domain.models.UserGroup;
import com.api.crud.domain.ports.in.UserGroup.CreateUserGroupUseCase;
import com.api.crud.domain.ports.out.UserGroupRepositoryPort;

public class CreateUserGroupUseCaseImpl implements CreateUserGroupUseCase {

    private final UserGroupRepositoryPort userGroupRepositoryPort;

    public CreateUserGroupUseCaseImpl(UserGroupRepositoryPort userGroupRepositoryPort) {
        this.userGroupRepositoryPort = userGroupRepositoryPort;
    }

    @Override
    public UserGroup createUserGroup(UserGroup userGroup) {
        return userGroupRepositoryPort.save(userGroup);
    }
}
