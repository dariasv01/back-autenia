package com.api.crud.domain.ports.in.Group;

import com.api.crud.domain.models.Group;

import java.util.Optional;

public interface UpdateGroupUseCase {
    Optional<Group> updateGroup(Group group, Long id);
}
