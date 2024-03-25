package com.api.crud.application.usecases.Spent;

import com.api.crud.domain.ports.in.Spent.DeleteSpentUseCase;
import com.api.crud.domain.ports.out.SpentRepositoryPort;

public class DeleteSpentUseCaseImpl implements DeleteSpentUseCase {

    private final SpentRepositoryPort spentRepositoryPort;

    public DeleteSpentUseCaseImpl(SpentRepositoryPort spentRepositoryPort) {
        this.spentRepositoryPort = spentRepositoryPort;
    }

    @Override
    public Boolean deleteSpent(Long id) {
        return spentRepositoryPort.deleteById(id);
    }
}
