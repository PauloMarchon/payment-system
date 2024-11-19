package com.payments.user.application.usecases.user.retrieve.email;

import com.payments.user.domain.user.User;

import java.time.Instant;
import java.time.LocalDate;

public record UserOutput(
        String id,
        String fullName,
        String identificationNumber,
        String email,
        LocalDate dateOfBirth,
        String phoneNumber,
        Instant createdAt
) {
    public static UserOutput from(User user) {
        return new UserOutput(
                user.getId().getValue(),
                user.getFullName(),
                user.getIdentificationNumber().getValue(),
                user.getEmail().getValue(),
                user.getDateOfBirth(),
                user.getPhoneNumber().getValue(),
                user.getCreatedAt()
        );
    }
}