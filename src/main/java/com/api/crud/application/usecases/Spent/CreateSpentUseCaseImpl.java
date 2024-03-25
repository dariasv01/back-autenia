package com.api.crud.application.usecases.Spent;

import com.api.crud.domain.models.Spent;
import com.api.crud.domain.ports.in.Spent.CreateSpentUseCase;
import com.api.crud.domain.ports.out.SpentRepositoryPort;

public class CreateSpentUseCaseImpl implements CreateSpentUseCase {

    private final SpentRepositoryPort spentRepositoryPort;

    public CreateSpentUseCaseImpl(SpentRepositoryPort spentRepositoryPort) {
        this.spentRepositoryPort = spentRepositoryPort;
    }

    @Override
    public Spent createSpents(Spent spent) {
        return spentRepositoryPort.save(spent);
    }
}
