package com.api.crud.domain.ports.out;

import com.api.crud.domain.models.Spent;

import java.util.List;
import java.util.Optional;

public interface SpentRepositoryPort {
    Spent save(Spent spent);
    Optional<Spent> findById(Long id);
    List<Spent> findAll();
    List<Spent> findByGroupId(Long id);

    List<Spent> findByGroupIdAndUserId(Long idGroup, Long idUser);

    Optional<Spent> update(Spent spent);
    boolean deleteById(Long id);

}
