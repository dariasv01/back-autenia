package com.api.crud.application.services;

import com.api.crud.domain.models.Group;
import com.api.crud.domain.ports.in.Group.CreateGroupUseCase;
import com.api.crud.domain.ports.in.Group.DeleteGroupUseCase;
import com.api.crud.domain.ports.in.Group.RetrieveGroupUseCase;
import com.api.crud.domain.ports.in.Group.UpdateGroupUseCase;
import java.util.List;
import java.util.Optional;

public class GroupServices implements CreateGroupUseCase,RetrieveGroupUseCase, UpdateGroupUseCase, DeleteGroupUseCase {
    private final CreateGroupUseCase createGroupUseCase;
    private final RetrieveGroupUseCase retrieveGroupUseCase;
    private final UpdateGroupUseCase updateGroupUseCase;
    private final DeleteGroupUseCase deleteGroupUseCase;

    public GroupServices(CreateGroupUseCase createGroupUseCase, RetrieveGroupUseCase retrieveGroupUseCase, UpdateGroupUseCase updateGroupUseCase, DeleteGroupUseCase deleteGroupUseCase) {
        this.createGroupUseCase = createGroupUseCase;
        this.retrieveGroupUseCase = retrieveGroupUseCase;
        this.updateGroupUseCase = updateGroupUseCase;
        this.deleteGroupUseCase = deleteGroupUseCase;
    }


    @Override
    public Group createGroup(Group group) {
        return createGroupUseCase.createGroup(group);
    }

    @Override
    public Boolean deleteGroup(Long id) {
        return deleteGroupUseCase.deleteGroup(id);
    }

    @Override
    public Optional<Group> updateGroup(Group group, Long id) {
        return updateGroupUseCase.updateGroup(group,id);
    }

    @Override
    public Optional<Group> getGroup(Long id) {
        return retrieveGroupUseCase.getGroup(id);
    }

    @Override
    public List<Group> getGroupsByUserId(Long id) {
        return retrieveGroupUseCase.getGroupsByUserId(id);
    }

    @Override
    public List<Group> getAllGroup() {
        return retrieveGroupUseCase.getAllGroup();
    }
}
