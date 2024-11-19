package com.payments.user.application.usecases.user.retrieve.email;

import com.payments.user.application.UseCase;
import com.payments.user.domain.user.User;
import com.payments.user.domain.user.UserRepository;
import com.payments.user.domain.valueobjects.Email;

public interface FindUserByEmailUseCase extends UseCase<FindUserByEmailInput, UserOutput> {

    class DefaultFindUserByEmailUseCase implements FindUserByEmailUseCase {
        private final UserRepository userRepository;

        public DefaultFindUserByEmailUseCase(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public UserOutput execute(FindUserByEmailInput findUserByEmailInput) {
            if (findUserByEmailInput.email() == null || findUserByEmailInput.email().isEmpty())
                throw new IllegalArgumentException("Email cannot be null or empty");

            final Email email = Email.of(findUserByEmailInput.email());

            final User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            return UserOutput.from(user);
        }
    }
}