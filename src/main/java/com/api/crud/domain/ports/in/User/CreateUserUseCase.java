package com.api.crud.domain.ports.in.User;

import com.api.crud.domain.models.User;

public interface CreateUserUseCase {
    User createUser(User user);

}
