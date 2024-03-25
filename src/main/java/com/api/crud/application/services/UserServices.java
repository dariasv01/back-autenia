package com.api.crud.application.services;

import com.api.crud.domain.models.User;
import com.api.crud.domain.ports.in.User.CreateUserUseCase;
import com.api.crud.domain.ports.in.User.DeleteUserUseCase;
import com.api.crud.domain.ports.in.User.RetrieveUserUseCase;
import com.api.crud.domain.ports.in.User.UpdateUserUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements CreateUserUseCase, DeleteUserUseCase, RetrieveUserUseCase, UpdateUserUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserServices(CreateUserUseCase createUserUseCase, DeleteUserUseCase deleteUserUseCase, RetrieveUserUseCase retrieveUserUseCase, UpdateUserUseCase updateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        return deleteUserUseCase.deleteUser(id);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return retrieveUserUseCase.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return retrieveUserUseCase.getAllUsers();
    }

    @Override
    public Optional<User> updateUser(User user, Long id) {
        return updateUserUseCase.updateUser(user,id);
    }
}
