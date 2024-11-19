package com.payments.user.application;

public interface UseCase<Input, Output> {
    abstract Output execute(Input input);
}