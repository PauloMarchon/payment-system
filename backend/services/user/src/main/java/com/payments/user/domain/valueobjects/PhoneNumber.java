package com.payments.user.domain.valueobjects;

import java.util.Objects;

public class PhoneNumber {
    private final String value;

    private PhoneNumber(String value) {
        Objects.requireNonNull(value);
        if (!isValid(value))
            throw new IllegalArgumentException("Invalid phone number");

        this.value = value;
    }

    public static PhoneNumber of(String value) {
        return new PhoneNumber(value);
    }

    private static boolean isValid(String value) {
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
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(value, that.value);
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
