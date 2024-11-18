package com.payments.user.domain.user;

import com.payments.user.domain.AggregateRoot;
import com.payments.user.domain.exception.NotificationException;
import com.payments.user.domain.validation.Notification;
import com.payments.user.domain.validation.ValidationHandler;
import com.payments.user.domain.valueobjects.Address;
import com.payments.user.domain.valueobjects.Email;
import com.payments.user.domain.valueobjects.IdentificationNumber;
import com.payments.user.domain.valueobjects.PhoneNumber;

import java.time.Instant;
import java.time.LocalDate;

public class User extends AggregateRoot<UserID> {
    private String fullName;
    private IdentificationNumber identificationNumber;
    private Email email;
    private LocalDate dateOfBirth;
    private PhoneNumber phoneNumber;
    private Instant createdAt;
    private Address address;

    private User(
            final UserID id,
            final String fullName,
            final IdentificationNumber identificationNumber,
            final Email email,
            final LocalDate birthDate,
            final PhoneNumber phoneNumber,
            final Instant createdAt) {
        super(id);
        this.fullName = fullName;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.dateOfBirth = birthDate;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;

        selfValidate();
    }

    public void selfValidate() {
        final var notification = Notification.create();
        validate(notification);

        if (notification.hasError())
            throw new NotificationException("Failed to create a user", notification);
    }

    public void validate(ValidationHandler handler) {
        new UserValidator(this, handler).validate();
    }

    public static User newUser(final UserID id, final String fullName, final IdentificationNumber identificationNumber, final Email email, final LocalDate birthDate, final PhoneNumber phoneNumber) {
        final Instant now = Instant.now();

        return new User(id, fullName, identificationNumber, email, birthDate, phoneNumber, now);
    }

    public static User newUser(final String fullName, final IdentificationNumber identificationNumber, final Email email, final LocalDate birthDate, final PhoneNumber phoneNumber) {
        final UserID id = UserID.unique();
        return newUser(id, fullName, identificationNumber, email, birthDate, phoneNumber);
    }

    public String getFullName() {
        return fullName;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    public Email getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return fullName;
    }
}