package com.achieversoft.ecommapp.productdata.controller;

import com.achieversoft.ecommapp.commonapplibrary.response.MonoResponseHelper;
import com.achieversoft.ecommapp.productdata.common.exception.ProductDataException;
import com.achieversoft.ecommapp.productdata.entity.Product;
import com.achieversoft.ecommapp.productdata.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.HTTP_STATUS_CODE_200;
import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.SUCCESS_STATUS_MESSAGE;
import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.SUCCESS_STAUS;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.DEL_ALL_PRODUCT_DETAILS;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.DEL_PRODUCT_DETAILS_BY_ID;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.GET_ALL_PRODUCT_DETAILS;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.GET_PRODUCT_DETAILS_BY_ID;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.SAVE_PRODUCT_DETAILS;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.SERVICE_NAME;
import static com.achieversoft.ecommapp.productdata.common.constants.ProductDataConstants.UPDATE_PRODUCT_DETAILS;


/**
 * The type Product controller.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    /**
     * Get product by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/details/{id}")
    @Operation(description = "Get product by id")
    public Object getProductById(@PathVariable String id){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.getProductById(id),GET_PRODUCT_DETAILS_BY_ID,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new ProductDataException(e.getMessage(),GET_PRODUCT_DETAILS_BY_ID);
        }
    }

    /**
     * Get products response entity.
     *
     * @return the response entity
     */
    @GetMapping("/details/all")
    public Object getProducts(){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                                     service.getProducts(),GET_ALL_PRODUCT_DETAILS,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new ProductDataException(e.getMessage(),GET_ALL_PRODUCT_DETAILS);
        }
    }


    /**
     * Save or update product response entity.
     *
     * @param list the list
     * @return the response entity
     */
    @PutMapping("/details/updt")
    public Object saveOrUpdateProduct(@RequestBody List<Product> list){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.saveOrUpdateProduct(list),UPDATE_PRODUCT_DETAILS,SUCCESS_STAUS,SERVICE_NAME);

        }catch (Exception e){
            throw new ProductDataException(e.getMessage(),UPDATE_PRODUCT_DETAILS);
        }

    }

    /**
     * Delete product response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @PostMapping("/details/dlt/{id}")
    public Object deleteProduct(@PathVariable String id){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.deleteProduct(id),DEL_PRODUCT_DETAILS_BY_ID,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new ProductDataException(e.getMessage(),DEL_PRODUCT_DETAILS_BY_ID);
        }

    }

    /**
     * Delete all product response entity.
     *
     * @return the response entity
     */
    @PostMapping("/details/dlt/all")
    public Object deleteAllProduct(){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.deleteAllProduct(),DEL_ALL_PRODUCT_DETAILS,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new ProductDataException(e.getMessage(),DEL_ALL_PRODUCT_DETAILS);
        }

    }




}
