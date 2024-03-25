package com.api.crud.domain.ports.in.Spent;

import com.api.crud.domain.models.Spent;

import java.util.Optional;

public interface UpdateSpentUseCase {
    Optional<Spent> updateSpents(Spent spent,Long id);
}
