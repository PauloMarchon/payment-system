package com.payments.user.application.usecases.user.create;

import com.payments.user.application.UseCase;
import com.payments.user.domain.user.User;
import com.payments.user.domain.user.UserRepository;
import com.payments.user.domain.valueobjects.Email;
import com.payments.user.domain.valueobjects.IdentificationNumber;
import com.payments.user.domain.valueobjects.PhoneNumber;

public interface CreateUserUseCase extends UseCase<CreateUserInput, String> {

    String execute(CreateUserInput input);

    class DefaultCreateUserUseCase implements CreateUserUseCase {
        private final UserRepository userRepository;

        public DefaultCreateUserUseCase(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public String execute(CreateUserInput input) {
            if (this.userRepository.findByEmail(Email.of(input.email())).isPresent())
                throw new IllegalArgumentException("Email already exists");

            final IdentificationNumber identificationNumber = IdentificationNumber.of(input.identificationNumber());
            final Email email = Email.of(input.email());
            final PhoneNumber phoneNumber = PhoneNumber.of(input.phoneNumber());

            final User user = User.newUser(input.fullName(), identificationNumber, email, input.birthDate(), phoneNumber);

            userRepository.create(user);

            return user.getId().getValue().toString();
        }
    }
}