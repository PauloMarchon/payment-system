package com.payments.account.domain.balance;

import com.payments.account.domain.valueobjects.MonetaryValue;

public interface BalanceOperations {
    Balance add(Balance balance, MonetaryValue value);
    Balance subtract(Balance balance, MonetaryValue value);
    Balance multiply(Balance balance, double value);
    Balance divide(Balance balance, double value);
}
