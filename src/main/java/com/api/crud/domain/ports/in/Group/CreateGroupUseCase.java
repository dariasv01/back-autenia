package com.api.crud.domain.ports.in.Group;

import com.api.crud.domain.models.Group;

public interface CreateGroupUseCase {
    Group createGroup(Group group);

}
