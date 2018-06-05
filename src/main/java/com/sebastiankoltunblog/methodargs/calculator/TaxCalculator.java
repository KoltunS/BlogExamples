package com.sebastiankoltunblog.methodargs.calculator;

import java.math.BigDecimal;

public class TaxCalculator {

    public BigDecimal calculateTax(BigDecimal price, BigDecimal taxAmount) {
        validateTaxAmount(taxAmount);
        validateProductPrice(price);
        return price.multiply(taxAmount);
    }

    private void validateTaxAmount(BigDecimal productTax) {
        //Some example 'complicated ' tax check
        if (productTax.compareTo(BigDecimal.ONE) >= 0) {
            throw new IllegalArgumentException("Tax percent is greater than 1!");
        }
    }

    private void validateProductPrice(BigDecimal price) {
        //Some example 'complicated ' price check
        if (price.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Product price is zero!");
        }
    }
}
