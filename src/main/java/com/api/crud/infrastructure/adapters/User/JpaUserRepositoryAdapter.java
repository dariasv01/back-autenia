package com.api.crud.infrastructure.adapters.User;

import com.api.crud.domain.models.User;
import com.api.crud.domain.ports.out.UserRepositoryPort;
import com.api.crud.infrastructure.entities.UserEntity;
import com.api.crud.infrastructure.repositories.User.JpaUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.frimDomainModel(user);
        UserEntity saveUserEntity = jpaUserRepository.save(userEntity);
        return saveUserEntity.toDomainModel();
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id).map(UserEntity::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream().map(UserEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<User> update(User user) {
        if (jpaUserRepository.existsById(user.getId())){
            UserEntity userEntity = UserEntity.frimDomainModel(user);
            UserEntity updateUserEntity = jpaUserRepository.save(userEntity);
            return Optional.of(updateUserEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaUserRepository.existsById(id)){
            jpaUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
