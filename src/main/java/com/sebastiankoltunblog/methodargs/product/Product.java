package com.sebastiankoltunblog.methodargs.product;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private BigDecimal price;

        private Builder() {
        }

        public static Builder aProduct() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            Objects.requireNonNull(id, "Id not set");
            Objects.requireNonNull(name, "Name not set");
            Objects.requireNonNull(price, "Price not set");
            Product product = new Product();
            product.name = this.name;
            product.price = this.price;
            product.id = this.id;
            return product;
        }
    }
}
