package com.api.crud.application.usecases.UserGroup;

import com.api.crud.domain.ports.in.User.DeleteUserUseCase;
import com.api.crud.domain.ports.in.UserGroup.DeleteUserGroupUseCase;
import com.api.crud.domain.ports.out.UserGroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;

public class DeleteUserGroupUseCaseImpl implements DeleteUserGroupUseCase {

    private final UserGroupRepositoryPort userGroupRepositoryPort;

    public DeleteUserGroupUseCaseImpl(UserGroupRepositoryPort userGroupRepositoryPort) {
        this.userGroupRepositoryPort = userGroupRepositoryPort;
    }

    @Override
    public Boolean deleteUserGroup(Long id) {
        return userGroupRepositoryPort.deleteById(id);
    }
}
