package com.api.crud.domain.ports.in.UserGroup;

import com.api.crud.domain.models.User;
import com.api.crud.domain.models.UserGroup;

import java.util.Optional;

public interface UpdateUserGroupUseCase {
    Optional<UserGroup> updateUserGroup(UserGroup userGroup);
}
