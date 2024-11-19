package com.payments.user.application.usecases.user.create;

import java.time.LocalDate;

public record CreateUserInput(
        String fullName,
        String identificationNumber,
        String email,
        LocalDate birthDate,
        String phoneNumber
) {
    public static CreateUserInput with(
            final String fullName,
            final String identificationNumber,
            final String email,
            final LocalDate birthDate,
            final String phoneNumber) {
        return new CreateUserInput(fullName, identificationNumber, email, birthDate, phoneNumber);
    }
}