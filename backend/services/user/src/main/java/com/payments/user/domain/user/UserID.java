package com.payments.user.domain.user;

import com.payments.user.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class UserID extends Identifier {
    private final UUID value;

    public UserID(final UUID value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static UserID unique() {
        return UserID.from(UUID.randomUUID());
    }

    public static UserID from(final String value) {
        return new UserID(UUID.fromString(value));
    }

    public static UserID from(final UUID value) {
        return new UserID(value);
    }

    @Override
    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserID userID = (UserID) o;
        return Objects.equals(value, userID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}