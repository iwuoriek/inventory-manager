package com.inventory.app.service;

import com.inventory.app.dto.BrandDto;
import com.inventory.app.dto.CategoryDto;
import com.inventory.app.model.Brand;
import com.inventory.app.model.Category;
import com.inventory.app.repository.BrandRepository;
import com.inventory.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandAndCategoryService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public BrandDto addBrand(BrandDto dto){
        return toBrandDto(brandRepository.save(dto.toBrand()));
    }

    public List<BrandDto> getBrands(){
        List<BrandDto> brandDtos = new ArrayList<>();
        brandRepository.findAll().forEach(brand -> brandDtos.add(toBrandDto(brand)));
        return brandDtos;
    }

    public void deleteBrand(BrandDto dto){
        brandRepository.delete(dto.toBrand());
    }

    public CategoryDto addCategory(CategoryDto dto){
        return toCategoryDto(categoryRepository.save(dto.toCategory()));
    }

    public List<CategoryDto> getCategories(){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categoryDtos.add(toCategoryDto(category)));
        return categoryDtos;
    }

    public void deleteCategory(CategoryDto dto){
        categoryRepository.delete(dto.toCategory());
    }

    public BrandDto toBrandDto(Brand brand){
        BrandDto brandDto = new BrandDto(brand.getName());
        brandDto.setId(brand.getId());
        return brandDto;
    }

    public CategoryDto toCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto(category.getName());
        categoryDto.setId(category.getId());
        return categoryDto;
    }
}
