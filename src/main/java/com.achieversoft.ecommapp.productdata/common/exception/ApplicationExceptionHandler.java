package com.achieversoft.ecommapp.productdata.common.exception;

import com.achieversoft.ecommapp.commonapplibrary.exception.GlobalExceptionHandler;
import com.achieversoft.ecommapp.commonapplibrary.response.ResponseHelper;
import com.achieversoft.ecommapp.commonapplibrary.response.ServiceResponse;
import com.achieversoft.ecommapp.productdata.common.exception.ProductDataException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.DEFAULT_TASK_NAME;
import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.ERROR_STAUS;
import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.HTTP_STATUS_CODE_500;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.SERVICE_NAME;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends GlobalExceptionHandler {

    /**
     * Handle product data exception response entity.
     *
     * @param e the exception
     * @return the response entity
     */
    @ExceptionHandler({ProductDataException.class})
    public ResponseEntity<ServiceResponse> handleProductDataException(ProductDataException e) {
        return ResponseHelper.buildAPIResponse(Boolean.FALSE,HTTP_STATUS_CODE_500,e.getMessage(),
                StringUtils.isNotEmpty(e.getTaskName())?e.getTaskName():DEFAULT_TASK_NAME,ERROR_STAUS,SERVICE_NAME);
    }
}
