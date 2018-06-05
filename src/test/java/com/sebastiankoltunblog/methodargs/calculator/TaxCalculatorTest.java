package com.sebastiankoltunblog.methodargs.calculator;

import com.sebastiankoltunblog.methodargs.product.Product;
import com.sebastiankoltunblog.methodargs.tax.ProductTax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {
    private TaxCalculator calculator;

    @BeforeEach
    public void init() {
        this.calculator = new TaxCalculator();
    }

    @Test
    public void calculatesTaxForProduct() {
        BigDecimal price = BigDecimal.valueOf(12.99);
        BigDecimal productTax = BigDecimal.valueOf(0.23);

        BigDecimal tax = calculator.calculateTax(price, productTax);

        assertEquals(BigDecimal.valueOf(2.9877), tax);
    }

                                        public void method(String[] args){

                                        }
}