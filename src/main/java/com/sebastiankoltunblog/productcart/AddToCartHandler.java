package com.sebastiankoltunblog.productcart;


import com.sebastiankoltunblog.commandhandler.CommandHandler;
import com.sebastiankoltunblog.dto.AddToCartCommand;
import org.apache.log4j.Logger;

import javax.inject.Named;

@Named
public class AddToCartHandler extends CommandHandler<AddToCartCommand, Void> {
    private static final Logger logger = Logger.getLogger(AddToCartHandler.class);

    @Override
    public Void handle(AddToCartCommand commandRequest) {
        logger.info("Adding " + commandRequest.getCount() +
                " productID " + commandRequest.getProductID() +
                " to UserID " + commandRequest.getUserID() + " productcart");
        return null;
    }
}
