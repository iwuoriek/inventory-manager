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
    private BrandAndCategoryService service;
    @Autowired
    private ProductRepository repository;

    public ProductDto addProduct(ProductDto dto){
        return toProductDto(repository.save(dto.toProduct()));
    }

    public ProductDto updateProduct(long id, ProductDto dto){
        Product prod = repository.findById(id).map(product -> {
            product.setName(dto.getName());
            product.setBrand(dto.getBrandDto().toBrand());
            product.setCategory(dto.getCategoryDto().toCategory());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());
            return repository.save(product);
        }).orElseThrow(() -> new NoSuchElementException("No entity found for product: " + dto.getId()));
        return toProductDto(prod);
    }

    public void deleteProduct(long id){
        repository.deleteById(id);
    }

    public ProductDto findProduct(long id){
        Product product = repository.findById(id)
                .orElseThrow(()->new NoSuchElementException("No entity found for product: " + id));
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
