package com.api.crud.infrastructure.adapters.Spent;

import com.api.crud.domain.models.Spent;
import com.api.crud.domain.ports.out.SpentRepositoryPort;
import com.api.crud.infrastructure.entities.SpentEntity;
import com.api.crud.infrastructure.repositories.Spent.JpaSpentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaSpentRepositoryAdapter implements SpentRepositoryPort {

    private final JpaSpentRepository jpaSpentRepository;

    public JpaSpentRepositoryAdapter(JpaSpentRepository jpaSpentRepository) {
        this.jpaSpentRepository = jpaSpentRepository;
    }

    @Override
    public Spent save(Spent spent) {
        SpentEntity spentEntity = SpentEntity.frimDomainModel(spent);
        SpentEntity saveSpentEntity = jpaSpentRepository.save(spentEntity);
        return saveSpentEntity.toDomainModel();
    }

    @Override
    public Optional<Spent> findById(Long id) {
        return jpaSpentRepository.findById(id).map(SpentEntity::toDomainModel);
    }

    @Override
    public List<Spent> findAll() {
        return jpaSpentRepository.findAll().stream().map(SpentEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public List<Spent> findByGroupId(Long id) {
        return jpaSpentRepository.findByIdGroup(id).stream().map(SpentEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public List<Spent> findByGroupIdAndUserId(Long idGroup, Long idUser) {
        return jpaSpentRepository.findByIdGroupAndIdUser(idGroup, idUser).stream().map(SpentEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Spent> update(Spent spent) {
        if (jpaSpentRepository.existsById(spent.getId())){
            SpentEntity spentEntity = SpentEntity.frimDomainModel(spent);
            SpentEntity updateSpentEntity = jpaSpentRepository.save(spentEntity);
            return Optional.of(updateSpentEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaSpentRepository.existsById(id)){
            jpaSpentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
