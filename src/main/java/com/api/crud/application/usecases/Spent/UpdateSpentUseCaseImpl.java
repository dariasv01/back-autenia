package com.api.crud.application.usecases.Spent;

import com.api.crud.domain.models.Spent;
import com.api.crud.domain.ports.in.Spent.UpdateSpentUseCase;
import com.api.crud.domain.ports.out.SpentRepositoryPort;

import java.util.Optional;

public class UpdateSpentUseCaseImpl implements UpdateSpentUseCase {

    private final SpentRepositoryPort spentRepositoryPort;

    public UpdateSpentUseCaseImpl(SpentRepositoryPort spentRepositoryPort) {
        this.spentRepositoryPort = spentRepositoryPort;
    }

    @Override
    public Optional<Spent> updateSpents(Spent spent, Long id) {
        return spentRepositoryPort.update(spent);
    }
}
