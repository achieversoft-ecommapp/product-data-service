package com.achieversoft.ecommapp.productdata.common.exception;

import lombok.Data;

/**
 * The type Product data exception.
 */
@Data
public class ProductDataException extends RuntimeException{

    private String taskName;
    /**
     * Instantiates a new Product data exception.
     *
     * @param message the message
     */
    public ProductDataException(String message){
        super(message);
    }

    public ProductDataException(String message, String taskName){
        super(message);
        this.taskName=taskName;
    }
}
