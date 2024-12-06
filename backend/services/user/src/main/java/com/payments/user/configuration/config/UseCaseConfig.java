package com.payments.user.configuration.config;

import com.payments.user.application.usecases.user.create.CreateUserUseCase;
import com.payments.user.application.usecases.user.retrieve.email.FindUserByEmailUseCase;
import com.payments.user.domain.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCase.DefaultCreateUserUseCase(userRepository);
    }

    @Bean
    public FindUserByEmailUseCase findUserByEmailUseCase(UserRepository userRepository) {
        return new FindUserByEmailUseCase.DefaultFindUserByEmailUseCase(userRepository);
    }
}
