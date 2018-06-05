package com.sebastiankoltunblog.methodargs.calculator;

import com.sebastiankoltunblog.methodargs.product.Product;
import com.sebastiankoltunblog.methodargs.tax.ProductTax;

import java.math.BigDecimal;

public class TaxCalculator {

    public BigDecimal calculateTax(Product product, ProductTax productTax) {
        BigDecimal taxAmount = getTaxAmount(productTax);
        BigDecimal price = getProductPrice(product);
        return price.multiply(taxAmount);
    }

    private BigDecimal getTaxAmount(ProductTax productTax) {
        BigDecimal taxPercent = productTax.getTaxPercent();
        //Some example 'complicated ' tax check
        if (taxPercent.compareTo(BigDecimal.ONE) >= 0) {
            throw new IllegalArgumentException("Tax percent is greater than 1!");
        }
        return taxPercent;
    }

    private BigDecimal getProductPrice(Product product) {
        BigDecimal price = product.getPrice();
        //Some example 'complicated ' price check
        if (price.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Product price is zero!");
        }
        return price;
    }
}
