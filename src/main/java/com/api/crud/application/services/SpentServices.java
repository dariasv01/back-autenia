package com.api.crud.application.services;

import com.api.crud.domain.models.Spent;
import com.api.crud.domain.ports.in.Spent.CreateSpentUseCase;
import com.api.crud.domain.ports.in.Spent.DeleteSpentUseCase;
import com.api.crud.domain.ports.in.Spent.RetrieveSpentUseCase;
import com.api.crud.domain.ports.in.Spent.UpdateSpentUseCase;

import java.util.List;
import java.util.Optional;

public class SpentServices implements CreateSpentUseCase, UpdateSpentUseCase, DeleteSpentUseCase, RetrieveSpentUseCase {
    private final CreateSpentUseCase createSpentUseCase;
    private final RetrieveSpentUseCase retrieveSpentUseCase;
    private final UpdateSpentUseCase updateSpentUseCase;
    private final DeleteSpentUseCase deleteSpentUseCase;

    public SpentServices(CreateSpentUseCase createSpentUseCase, RetrieveSpentUseCase retrieveSpentUseCase, UpdateSpentUseCase updateSpentUseCase, DeleteSpentUseCase deleteSpentUseCase) {
        this.createSpentUseCase = createSpentUseCase;
        this.retrieveSpentUseCase = retrieveSpentUseCase;
        this.updateSpentUseCase = updateSpentUseCase;
        this.deleteSpentUseCase = deleteSpentUseCase;
    }

    @Override
    public Spent createSpents(Spent spent) {
        return createSpentUseCase.createSpents(spent);
    }

    public Boolean deleteSpent(Long id) {
        return deleteSpentUseCase.deleteSpent(id);
    }

    @Override
    public Optional<Spent> getSpent(Long id) {
        return retrieveSpentUseCase.getSpent(id);
    }

    @Override
    public List<Spent> getAllSpents() {
        return retrieveSpentUseCase.getAllSpents();
    }

    @Override
    public List<Spent> getSpentsByGroupId(Long id) {
        return retrieveSpentUseCase.getSpentsByGroupId(id);
    }

    @Override
    public List<Spent> getSpentsByGroupIdAndUserId(Long idGroup, Long idUser) {
        return retrieveSpentUseCase.getSpentsByGroupIdAndUserId(idGroup,idUser);
    }

    @Override
    public Optional<Spent> updateSpents(Spent spent, Long id) {
        return updateSpentUseCase.updateSpents(spent, id);
    }
}
