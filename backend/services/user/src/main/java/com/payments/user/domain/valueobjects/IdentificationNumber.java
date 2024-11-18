package com.payments.user.domain.valueobjects;

import java.util.Objects;

public class IdentificationNumber {
    private final String value;

    private IdentificationNumber(String value) {
        Objects.requireNonNull(value);
        if (!isValid(value))
            throw new IllegalArgumentException("Value is not a valid identification number");

        this.value = value;
    }

    public static IdentificationNumber of(String value) {
        return new IdentificationNumber(value);
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
        IdentificationNumber that = (IdentificationNumber) o;
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