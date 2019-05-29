package com.inventory.app.service;

import com.inventory.app.dto.ProductDto;
import com.inventory.app.model.Product;
import com.inventory.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    BrandAndCategoryService service;
    @Autowired
    ProductRepository repository;

    public ProductDto addProduct(ProductDto dto){
        return toProductDto(repository.save(dto.toProduct()));
    }

    public void deleteProduct(ProductDto dto){
        repository.delete(dto.toProduct());
    }

    public ProductDto findProduct(ProductDto dto){
        Product product = repository.findById(dto.getId())
                .orElseThrow(()->new NoSuchElementException("No entity found for product: " + dto.getId()));
        return toProductDto(product);
    }

    public List<ProductDto> findAllProducts(){
        List<ProductDto> productDtos = new ArrayList<>();
        repository.findAll().forEach(product -> productDtos.add(toProductDto(product)));
        return productDtos;
    }

    public ProductDto toProductDto(Product product){
        return new ProductDto(product.getId(), product.getName(), service.toBrandDto(product.getBrand()),
                service.toCategoryDto(product.getCategory()), product.getQuantity(), product.getPrice());
    }
}
