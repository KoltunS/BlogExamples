package com.sebastiankoltunblog.productcart;

import com.sebastiankoltunblog.core.CommandRequest;

public class AddToCartCommand extends CommandRequest<Void> {
    private String productID;
    private Long userID;
    private Integer count;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
