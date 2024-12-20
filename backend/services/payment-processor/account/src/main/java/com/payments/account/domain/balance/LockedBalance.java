package com.payments.account.domain.balance;

import java.util.Currency;

public class LockedBalance extends Balance {

    private LockedBalance(final long amount, final Currency currency) {
        super(amount, currency);
    }

    public static LockedBalance of(final long lockedBalance, final Currency currency) {
        return new LockedBalance(lockedBalance, currency);
    }

    @Override
    public Balance updateBalance(final long amount) {
        return new LockedBalance(amount, this.currency);
    }
}