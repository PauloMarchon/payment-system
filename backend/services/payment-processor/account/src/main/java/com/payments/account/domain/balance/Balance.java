package com.payments.account.domain.balance;

import java.math.BigDecimal;
import java.util.Currency;

public abstract class Balance {
    protected final long amountInCents;
    protected final Currency currency;

    protected Balance(final long amountInCents, final Currency currency) {
        this.amountInCents = amountInCents;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return new BigDecimal(amountInCents);
    }

    public long getAmountInCents() {
        return amountInCents;
    }

    public Currency getCurrency() {
        return currency;
    }

    public abstract Balance updateBalance(final long amount);
}