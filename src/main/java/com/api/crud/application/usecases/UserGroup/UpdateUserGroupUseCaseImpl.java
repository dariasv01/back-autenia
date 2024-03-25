package com.api.crud.application.usecases.UserGroup;

import com.api.crud.domain.models.User;
import com.api.crud.domain.models.UserGroup;
import com.api.crud.domain.ports.in.User.UpdateUserUseCase;
import com.api.crud.domain.ports.in.UserGroup.UpdateUserGroupUseCase;
import com.api.crud.domain.ports.out.UserGroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class UpdateUserGroupUseCaseImpl implements UpdateUserGroupUseCase {

    private final UserGroupRepositoryPort userGroupRepositoryPort;

    public UpdateUserGroupUseCaseImpl(UserGroupRepositoryPort userGroupRepositoryPort) {
        this.userGroupRepositoryPort = userGroupRepositoryPort;
    }

    @Override
    public Optional<UserGroup> updateUserGroup(UserGroup userGroup) {
        return userGroupRepositoryPort.update(userGroup);
    }
}
