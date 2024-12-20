package com.payments.account.infrastructure;

import com.payments.account.domain.balance.Balance;
import com.payments.account.domain.balance.BalanceOperations;
import com.payments.account.domain.valueobjects.MonetaryValue;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.money.MoneyUtils;

import java.math.RoundingMode;

public class BalanceOperationsJodaMoney implements BalanceOperations {

    @Override
    public Balance add(Balance balance, MonetaryValue value) {
        Money currentBalanceAmount = Money.of(CurrencyUnit.of(balance.getCurrency()), balance.getAmountInCents());
        Money valueToAdd = Money.of(CurrencyUnit.of(value.currency()), value.amount().longValueExact());

        if (!valueToAdd.isSameCurrency(currentBalanceAmount)) {
            //TODO
        }

        Money result = MoneyUtils.add(currentBalanceAmount, valueToAdd);

        return balance.updateBalance(result.getAmountMinorLong());
    }

    @Override
    public Balance subtract(Balance balance, MonetaryValue value) {
        Money currentBalanceAmount = Money.of(CurrencyUnit.of(balance.getCurrency()), balance.getAmountInCents());
        Money valueToAdd = Money.of(CurrencyUnit.of(value.currency()), value.amount().longValueExact());

        if (!valueToAdd.isSameCurrency(currentBalanceAmount)) {
            //TODO
        }

        Money result = MoneyUtils.subtract(currentBalanceAmount, valueToAdd);

        return balance.updateBalance(result.getAmountMinorLong());
    }

    @Override
    public Balance multiply(Balance balance, double value) {
        Money currentBalanceAmount = Money.of(CurrencyUnit.of(balance.getCurrency()), balance.getAmountInCents());

        Money result = currentBalanceAmount.multipliedBy(value, RoundingMode.UNNECESSARY);

        return balance.updateBalance(result.getAmountMinorLong());
    }

    @Override
    public Balance divide(Balance balance, double value) {
        Money currentBalanceAmount = Money.of(CurrencyUnit.of(balance.getCurrency()), balance.getAmountInCents());

        Money result = currentBalanceAmount.dividedBy(value, RoundingMode.UNNECESSARY);

        return balance.updateBalance(result.getAmountMinorLong());
    }
}