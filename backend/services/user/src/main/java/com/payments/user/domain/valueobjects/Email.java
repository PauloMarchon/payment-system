package com.payments.user.domain.valueobjects;

import java.util.Objects;

public class Email {
    private final String value;

    private Email(final String value) {
        Objects.requireNonNull(value);
        if (!isValid(value))
            throw new IllegalArgumentException();

        this.value = value;
    }

    public static Email of(final String value) {
        return new Email(value);
    }

    private static boolean isValid(final String value) {
        //TODO
        return true;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}