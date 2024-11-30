package com.payments.user.application;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}