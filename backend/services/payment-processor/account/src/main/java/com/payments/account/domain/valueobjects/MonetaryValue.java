package com.payments.account.domain.valueobjects;

import java.math.BigDecimal;
import java.util.Currency;

public record MonetaryValue(
        BigDecimal amount,
        Currency currency)
{

}
