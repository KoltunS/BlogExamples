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
    public void init(){
        this.calculator = new TaxCalculator();
    }

    @Test
    public void calculatesTaxForProduct() {
        Product product = getProduct(12.99);
        ProductTax productTax = getProductTax(0.23);

        BigDecimal tax = calculator.calculateTax(product, productTax);

        assertEquals(BigDecimal.valueOf(2.9877),tax);
    }

    private Product getProduct(double price) {
        return Product.Builder.aProduct()
                .id(1L)
                .name("name")
                .price(BigDecimal.valueOf(price))
                .build();
    }

    private ProductTax getProductTax(double tax) {
        return ProductTax.Builder.aProductTax()
                .id(1L)
                .taxAmount(BigDecimal.valueOf(tax))
                .maxProductCount(100L)
                .taxInfo("Some info")
                .build();
    }
}