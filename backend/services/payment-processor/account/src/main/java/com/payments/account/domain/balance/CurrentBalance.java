package com.payments.account.domain.balance;

import java.util.Currency;

public class CurrentBalance extends Balance {

    private CurrentBalance(final long amount, final Currency currency) {
        super(amount, currency);
    }

    public static CurrentBalance of(final long balance, final Currency currency) {
        return new CurrentBalance(balance, currency);
    }

    @Override
    public Balance updateBalance(final long amount) {
        return new CurrentBalance(amount, this.currency);
    }
}