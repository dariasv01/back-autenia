package com.api.crud.infrastructure.config;

import com.api.crud.application.services.GroupServices;
import com.api.crud.application.services.SpentServices;
import com.api.crud.application.services.UserGroupServices;
import com.api.crud.application.services.UserServices;
import com.api.crud.application.usecases.Group.CreateGroupUseCaseImpl;
import com.api.crud.application.usecases.Group.DeleteGroupUseCaseImpl;
import com.api.crud.application.usecases.Group.RetriveGroupUseCaseImpl;
import com.api.crud.application.usecases.Group.UpdateGroupUseCaseImpl;
import com.api.crud.application.usecases.Spent.CreateSpentUseCaseImpl;
import com.api.crud.application.usecases.Spent.DeleteSpentUseCaseImpl;
import com.api.crud.application.usecases.Spent.RetriveSpentUseCaseImpl;
import com.api.crud.application.usecases.Spent.UpdateSpentUseCaseImpl;
import com.api.crud.application.usecases.UserGroup.CreateUserGroupUseCaseImpl;
import com.api.crud.application.usecases.UserGroup.DeleteUserGroupUseCaseImpl;
import com.api.crud.application.usecases.UserGroup.RetriveUserGroupUseCaseImpl;
import com.api.crud.application.usecases.UserGroup.UpdateUserGroupUseCaseImpl;
import com.api.crud.application.usecases.Users.CreateUserUseCaseImpl;
import com.api.crud.application.usecases.Users.DeleteUserUseCaseImpl;
import com.api.crud.application.usecases.Users.RetriveUserUseCaseImpl;
import com.api.crud.application.usecases.Users.UpdateUserUseCaseImpl;
import com.api.crud.domain.ports.out.GroupRepositoryPort;
import com.api.crud.domain.ports.out.SpentRepositoryPort;
import com.api.crud.domain.ports.out.UserGroupRepositoryPort;
import com.api.crud.domain.ports.out.UserRepositoryPort;
import com.api.crud.infrastructure.adapters.Group.JpaGroupRepositoryAdapter;
import com.api.crud.infrastructure.adapters.Spent.JpaSpentRepositoryAdapter;
import com.api.crud.infrastructure.adapters.User.JpaUserRepositoryAdapter;
import com.api.crud.infrastructure.adapters.UserGroup.JpaUserGroupRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public SpentServices spentServices(SpentRepositoryPort spentRepositoryPort){
        return new SpentServices(
               new CreateSpentUseCaseImpl(spentRepositoryPort),
               new RetriveSpentUseCaseImpl(spentRepositoryPort),
               new UpdateSpentUseCaseImpl(spentRepositoryPort),
               new DeleteSpentUseCaseImpl(spentRepositoryPort)
        );
    }

    @Bean
    public SpentRepositoryPort spentRepositoryPort(JpaSpentRepositoryAdapter jpaSpentRepositoryAdapter){
        return jpaSpentRepositoryAdapter;
    }

    @Bean
    public UserServices userServices(UserRepositoryPort userRepositoryPort){
        return new UserServices(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort),
                new RetriveUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter){
        return jpaUserRepositoryAdapter;
    }

    @Bean
    public GroupServices groupServices(GroupRepositoryPort groupRepositoryPort) {
        return new GroupServices(
                new CreateGroupUseCaseImpl(groupRepositoryPort),
                new RetriveGroupUseCaseImpl(groupRepositoryPort),
                new UpdateGroupUseCaseImpl(groupRepositoryPort),
                new DeleteGroupUseCaseImpl(groupRepositoryPort));
    }

    @Bean
    public GroupRepositoryPort groupRepositoryPort(JpaGroupRepositoryAdapter jpaGroupRepositoryAdapter){
        return jpaGroupRepositoryAdapter;
    }

    @Bean
    public UserGroupServices userGroupServices(UserGroupRepositoryPort userGroupRepositoryPort){
        return new UserGroupServices(
                new CreateUserGroupUseCaseImpl(userGroupRepositoryPort),
                new RetriveUserGroupUseCaseImpl(userGroupRepositoryPort),
                new UpdateUserGroupUseCaseImpl(userGroupRepositoryPort),
                new DeleteUserGroupUseCaseImpl(userGroupRepositoryPort));
    }

    @Bean
    public UserGroupRepositoryPort userGroupRepositoryPort(JpaUserGroupRepositoryAdapter jpaUserGroupRepositoryAdapter){
        return jpaUserGroupRepositoryAdapter;
    }
}
