package com.api.crud.infrastructure.adapters.UserGroup;

import com.api.crud.domain.models.User;
import com.api.crud.domain.models.UserGroup;
import com.api.crud.domain.ports.out.UserGroupRepositoryPort;
import com.api.crud.infrastructure.entities.UserGroupEntity;
import com.api.crud.infrastructure.repositories.UserGroup.JpaUserGroupRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaUserGroupRepositoryAdapter implements UserGroupRepositoryPort {

    private final JpaUserGroupRepository jpaUserGroupRepository;

    public JpaUserGroupRepositoryAdapter(JpaUserGroupRepository jpaUserGroupRepository) {
        this.jpaUserGroupRepository = jpaUserGroupRepository;
    }

    @Override
    public UserGroup save(UserGroup userGroup) {
        UserGroupEntity userGroupEntity = UserGroupEntity.frimDomainModel(userGroup);
        UserGroupEntity saveUserGroupEntity = jpaUserGroupRepository.save(userGroupEntity);
        return saveUserGroupEntity.toDomainModel();
    }

    @Override
    public Optional<UserGroup> findById(Long id) {
        return jpaUserGroupRepository.findById(id).map(UserGroupEntity::toDomainModel);
    }

    @Override
    public List<UserGroup> findAll() {
        return jpaUserGroupRepository.findAll().stream().map(UserGroupEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public List<UserGroup> findByGroupId(Long id) {
        return jpaUserGroupRepository.findGroupEntitiesByGroupId(id).stream().map(UserGroupEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public List<UserGroup> findByUserId(Long id) {
        return jpaUserGroupRepository.findGroupEntitiesByUserId(id).stream().map(UserGroupEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<UserGroup> update(UserGroup userGroup) {
        if (jpaUserGroupRepository.existsById(userGroup.getId())){
            UserGroupEntity userGroupEntity = UserGroupEntity.frimDomainModel(userGroup);
            UserGroupEntity updateUserGroupEntity = jpaUserGroupRepository.save(userGroupEntity);
            return Optional.of(updateUserGroupEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaUserGroupRepository.existsById(id)){
            jpaUserGroupRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
