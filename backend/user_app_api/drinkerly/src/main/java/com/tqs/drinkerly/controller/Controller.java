package com.tqs.drinkerly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.tqs.drinkerly.model.User;
import com.tqs.drinkerly.model.Request;
import com.tqs.drinkerly.service.RequestService;
import com.tqs.drinkerly.model.Product;
import com.tqs.drinkerly.service.ProductService;

@RequestMapping("/v1/")
@RestController
class Controller {

    @Autowired
    RequestService requestService;

    @Autowired
    ProductService productService;

    @GetMapping("/some_endpoint")
    @ResponseBody
    String getSomeEndPoint(@RequestParam(required = false) Optional<String> date)
            throws IOException, InterruptedException {
        return "okey";
    }

    @PostMapping("/request")
    public ResponseEntity<Void> postRequest(@RequestBody Request request) {

        requestService.saveRequest(request);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("request/{id}")
	public Request getRequestById(@PathVariable(value = "id") long id) {
		return requestService.getRequestById(id);
	}

    @GetMapping("/allproducts")
    public List<Product> getProducts(){
        return (List<Product>) productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(value = "id") long id){
        return productService.getProduct(id);
    }
    
}
 