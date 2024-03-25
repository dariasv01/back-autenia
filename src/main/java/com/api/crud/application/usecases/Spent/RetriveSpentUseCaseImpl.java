package com.api.crud.application.usecases.Spent;

import com.api.crud.domain.models.Spent;
import com.api.crud.domain.ports.in.Spent.RetrieveSpentUseCase;
import com.api.crud.domain.ports.out.SpentRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriveSpentUseCaseImpl implements RetrieveSpentUseCase {

    private final SpentRepositoryPort spentRepositoryPort;

    public RetriveSpentUseCaseImpl(SpentRepositoryPort spentRepositoryPort) {
        this.spentRepositoryPort = spentRepositoryPort;
    }

    @Override
    public Optional<Spent> getSpent(Long id) {
        return spentRepositoryPort.findById(id);
    }

    @Override
    public List<Spent> getAllSpents() {
        return spentRepositoryPort.findAll();
    }

    @Override
    public List<Spent> getSpentsByGroupId(Long id) {
        return spentRepositoryPort.findByGroupId(id);
    }

    @Override
    public List<Spent> getSpentsByGroupIdAndUserId(Long idGroup, Long idUser) {
        return spentRepositoryPort.findByGroupIdAndUserId(idGroup,idUser);
    }
}
