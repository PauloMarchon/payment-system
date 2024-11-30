package com.payments.user.application.usecases.user.create;

import com.payments.user.domain.user.User;

import java.time.Instant;
import java.time.LocalDate;

public record CreateUserOutput(
        String id,
        String fullName,
        String identificationNumber,
        String email,
        LocalDate dateOfBirth,
        String phoneNumber,
        Instant createdAt
) {
    public static CreateUserOutput from(
            final String id,
            final String fullName,
            final String identificationNumber,
            final String email,
            final LocalDate dateOfBirth,
            final String phoneNumber,
            final Instant createdAt) {
        return new CreateUserOutput(id, fullName, identificationNumber, email, dateOfBirth, phoneNumber, createdAt);
    }

    public static CreateUserOutput from(User user) {
        return new CreateUserOutput(
                user.getId().getValue(),
                user.getFullName(),
                user.getIdentificationNumber().getValue(),
                user.getEmail().getValue(),
                user.getBirthDate(),
                user.getPhoneNumber().getValue(),
                user.getCreatedAt()
        );
    }
}