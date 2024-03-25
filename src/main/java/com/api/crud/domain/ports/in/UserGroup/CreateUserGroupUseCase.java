package com.api.crud.domain.ports.in.UserGroup;


import com.api.crud.domain.models.UserGroup;

public interface CreateUserGroupUseCase {
    UserGroup createUserGroup(UserGroup userGroup);

}
