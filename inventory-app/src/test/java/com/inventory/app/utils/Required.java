package com.inventory.app.utils;

import com.inventory.app.dto.BrandDto;
import com.inventory.app.dto.CategoryDto;
import com.inventory.app.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class Required {

    public static BrandDto brandDto(){
        return new BrandDto("Nike");
    }

    public static CategoryDto categoryDto(){
        return new CategoryDto("Shirts");
    }

    public static ProductDto productDto(BrandDto brandDto, CategoryDto categoryDto) {
        return new ProductDto(1011, "Long Line T's", brandDto, categoryDto, 5, 29.99);
    }

    public static List<ProductDto> productDtoList(BrandDto brandDto, CategoryDto categoryDto){
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto(1011, "Long Line T's", brandDto, categoryDto, 5, 29.99));
        productDtos.add(new ProductDto(1012, "Skinny Xs", brandDto, categoryDto, 15, 27.99));
        productDtos.add(new ProductDto(1013, "Slim Fit", brandDto, categoryDto, 11, 19.99));
        productDtos.add(new ProductDto(1014, "White Summer", brandDto, categoryDto, 25, 24.99));
        productDtos.add(new ProductDto(1015, "Beach V's", brandDto, categoryDto, 50, 25.99));
        productDtos.add(new ProductDto(1016, "Silver Ring", brandDto, categoryDto, 53, 29.99));
        return  productDtos;
    }

}
