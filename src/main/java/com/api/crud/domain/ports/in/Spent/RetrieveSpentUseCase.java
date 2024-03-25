package com.api.crud.domain.ports.in.Spent;

import com.api.crud.domain.models.Spent;

import java.util.List;
import java.util.Optional;

public interface RetrieveSpentUseCase {
    Optional<Spent> getSpent(Long id);
    List<Spent> getAllSpents();
    List<Spent> getSpentsByGroupId(Long id);

    List<Spent> getSpentsByGroupIdAndUserId(Long idGroup, Long idUser);
}
