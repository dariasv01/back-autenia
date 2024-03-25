package com.api.crud.domain.ports.in.Group;

import com.api.crud.domain.models.Group;

import java.util.List;
import java.util.Optional;

public interface RetrieveGroupUseCase {
    Optional<Group> getGroup(Long id);
    List<Group> getGroupsByUserId(Long id);
    List<Group> getAllGroup();
}
