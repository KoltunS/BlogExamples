package com.sebastiankoltunblog.methodargs.tax;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductTax {
    private Long id;
    private BigDecimal taxPercent;
    private Long maxProductCount;
    private String taxInfo;

    public Long getId() {
        return id;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public Long getMaxProductCount() {
        return maxProductCount;
    }

    public String getTaxInfo() {
        return taxInfo;
    }

    public static final class Builder {
        private Long id;
        private BigDecimal taxAmount;
        private Long maxProductCount;
        private String taxInfo;

        private Builder() {
        }

        public static Builder aProductTax() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder taxAmount(BigDecimal taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        public Builder maxProductCount(Long maxProductCount) {
            this.maxProductCount = maxProductCount;
            return this;
        }

        public Builder taxInfo(String taxInfo) {
            this.taxInfo = taxInfo;
            return this;
        }

        public ProductTax build() {
            Objects.requireNonNull(id, "Id not set");
            Objects.requireNonNull(maxProductCount, "MaxProductCount not set");
            Objects.requireNonNull(taxAmount, "TaxAmount not set");
            Objects.requireNonNull(taxInfo, "TaxInfo not set");
            ProductTax productTax = new ProductTax();
            productTax.taxInfo = this.taxInfo;
            productTax.id = this.id;
            productTax.maxProductCount = this.maxProductCount;
            productTax.taxPercent = this.taxAmount;
            return productTax;
        }
    }
}
