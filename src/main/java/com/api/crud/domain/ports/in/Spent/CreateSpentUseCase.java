package com.api.crud.domain.ports.in.Spent;

import com.api.crud.domain.models.Spent;

public interface CreateSpentUseCase {
    Spent createSpents(Spent spent);

}
