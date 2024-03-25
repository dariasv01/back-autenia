package com.api.crud.infrastructure.adapters.Group;

import com.api.crud.domain.models.Group;
import com.api.crud.domain.ports.out.GroupRepositoryPort;
import com.api.crud.infrastructure.entities.GroupEntity;
import com.api.crud.infrastructure.repositories.Group.JpaGroupRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaGroupRepositoryAdapter implements GroupRepositoryPort {

    private final JpaGroupRepository jpaGroupRepository;

    public JpaGroupRepositoryAdapter(JpaGroupRepository jpaGroupRepository) {
        this.jpaGroupRepository = jpaGroupRepository;
    }

    @Override
    public Group save(Group group) {
        GroupEntity groupEntity = GroupEntity.frimDominModel(group);
        GroupEntity saveGroupEntity = jpaGroupRepository.save(groupEntity);
        return saveGroupEntity.toDomainModel();
    }

    @Override
    public Optional<Group> findById(Long id) {
        return jpaGroupRepository.findById(id).map(GroupEntity::toDomainModel);
    }

    @Override
    public List<Group> findAll() {
        return jpaGroupRepository.findAll().stream().map(GroupEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public List<Group> findByIdUser(Long id) {
        return jpaGroupRepository.findByIdUser(id);
    }

    @Override
    public Optional<Group> update(Group group) {
        if (jpaGroupRepository.existsById(group.getId())){
            GroupEntity groupEntity = GroupEntity.frimDominModel(group);
            GroupEntity updateGroupEntity = jpaGroupRepository.save(groupEntity);
            return Optional.of(updateGroupEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaGroupRepository.existsById(id)){
            jpaGroupRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
