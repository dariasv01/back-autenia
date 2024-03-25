package com.api.crud.domain.ports.in.UserGroup;

import com.api.crud.domain.models.UserGroup;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserGroupUseCase {
    Optional<UserGroup> getUserGroup(Long id);
    List<UserGroup> getAllUsersGroups();
    List<UserGroup> getAllUser(Long idGroup);
    List<UserGroup> getAllGroup(Long idUser);
}
