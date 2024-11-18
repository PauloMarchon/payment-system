package com.payments.user.domain.user;

import com.payments.user.domain.validation.ValidationHandler;
import com.payments.user.domain.validation.Validator;

public class UserValidator extends Validator {
    private final User user;

    protected UserValidator(final User user, ValidationHandler handler) {
        super(handler);
        this.user = user;
    }

    @Override
    public void validate() {
        //TODO
    }
}
