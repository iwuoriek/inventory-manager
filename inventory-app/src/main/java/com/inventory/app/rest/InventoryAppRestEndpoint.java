package com.inventory.app.rest;

import com.inventory.app.dto.*;
import com.inventory.app.model.Sales;
import com.inventory.app.service.BrandAndCategoryService;
import com.inventory.app.service.ProductService;
import com.inventory.app.service.SalesService;
import com.inventory.app.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/inventory")
public class InventoryAppRestEndpoint {
    @Autowired
    private UserAccountService accountService;
    @Autowired
    private BrandAndCategoryService brandAndCategoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SalesService salesService;

    @PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserAccountDto> addUser(@RequestBody UserAccountDto dto){
        UserAccountDto userAccountDto = accountService.registerNewUser(dto);
        return new ResponseEntity<>(userAccountDto, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{username}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserAccountDto> getUser(@PathVariable String username){
        UserAccountDto userAccountDto = accountService.getUser(username);
        return new ResponseEntity<>(userAccountDto, HttpStatus.OK);
    }

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UserAccountDto>> getAllUsers(){
        List<UserAccountDto> users = accountService.getUserList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(path = "/brand", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BrandDto> addBrand(@RequestBody BrandDto dto){
        BrandDto brandDto = brandAndCategoryService.addBrand(dto);
        return new ResponseEntity<>(brandDto, HttpStatus.OK);
    }

    @GetMapping(path = "/brand", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BrandDto>> getBrands(){
        List<BrandDto> brandDtos = brandAndCategoryService.getBrands();
        return new ResponseEntity<>(brandDtos,HttpStatus.OK);
    }

    @DeleteMapping(path = "brand/{id}")
    public ResponseEntity deleteBrand(@PathVariable long id){
        brandAndCategoryService.deleteBrand(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "/category", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto dto){
        CategoryDto categoryDto = brandAndCategoryService.addCategory(dto);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping(path = "/category", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categoryDtos = brandAndCategoryService.getCategories();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

    @DeleteMapping(path = "/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id){
        brandAndCategoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto dto){
        ProductDto productDto = productService.addProduct(dto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping(path = "/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> productDtos = productService.findAllProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id){
        ProductDto productDto = productService.findProduct(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id,
                                                    @RequestBody ProductDto dto){
        ProductDto productDto = productService.updateProduct(id, dto);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "/sales", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SalesDto> addSales(@RequestBody SalesDto dto){
        SalesDto salesDto = salesService.addSales(dto);
        return new ResponseEntity<>(salesDto, HttpStatus.OK);
    }

    @GetMapping(path = "/sales/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SalesDto> getSales(@PathVariable String id){
        SalesDto salesDto = salesService.getSales(id);
        return new ResponseEntity<>(salesDto, HttpStatus.OK);
    }

    @GetMapping(path = "/sales", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SalesDto>> getAllSales(){
        List<SalesDto> sales = salesService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
}
