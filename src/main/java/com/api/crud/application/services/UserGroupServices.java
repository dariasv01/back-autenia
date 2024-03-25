package com.api.crud.application.services;

import com.api.crud.domain.models.UserGroup;
import com.api.crud.domain.ports.in.UserGroup.CreateUserGroupUseCase;
import com.api.crud.domain.ports.in.UserGroup.DeleteUserGroupUseCase;
import com.api.crud.domain.ports.in.UserGroup.RetrieveUserGroupUseCase;
import com.api.crud.domain.ports.in.UserGroup.UpdateUserGroupUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupServices implements CreateUserGroupUseCase, RetrieveUserGroupUseCase, UpdateUserGroupUseCase, DeleteUserGroupUseCase {
    private final CreateUserGroupUseCase createUserGroupUseCase;
    private final RetrieveUserGroupUseCase retrieveUserGroupUseCase;
    private final UpdateUserGroupUseCase updateUserGroupUseCase;
    private final DeleteUserGroupUseCase deleteUserGroupUseCase;

    public UserGroupServices(CreateUserGroupUseCase createUserGroupUseCase, RetrieveUserGroupUseCase retrieveUserGroupUseCase, UpdateUserGroupUseCase updateUserGroupUseCase, DeleteUserGroupUseCase deleteUserGroupUseCase) {
        this.createUserGroupUseCase = createUserGroupUseCase;
        this.retrieveUserGroupUseCase = retrieveUserGroupUseCase;
        this.updateUserGroupUseCase = updateUserGroupUseCase;
        this.deleteUserGroupUseCase = deleteUserGroupUseCase;
    }

    @Override
    public UserGroup createUserGroup(UserGroup userGroup) {
        return createUserGroupUseCase.createUserGroup(userGroup);
    }

    @Override
    public Boolean deleteUserGroup(Long id) {
        return deleteUserGroupUseCase.deleteUserGroup(id);
    }

    @Override
    public Optional<UserGroup> getUserGroup(Long id) {
        return retrieveUserGroupUseCase.getUserGroup(id);
    }

    @Override
    public List<UserGroup> getAllUsersGroups() {
        return retrieveUserGroupUseCase.getAllUsersGroups();
    }

    @Override
    public List<UserGroup> getAllUser(Long idGroup) {
        return retrieveUserGroupUseCase.getAllUser(idGroup);
    }

    @Override
    public List<UserGroup> getAllGroup(Long idUser) {
        return retrieveUserGroupUseCase.getAllGroup(idUser);
    }

    @Override
    public Optional<UserGroup> updateUserGroup(UserGroup userGroup) {
        return updateUserGroupUseCase.updateUserGroup(userGroup);
    }
}
