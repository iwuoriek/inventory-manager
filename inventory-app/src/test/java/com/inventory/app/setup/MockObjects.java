package com.inventory.app.setup;

import com.inventory.app.dto.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MockObjects {
    private static List<BusinessDto> BUSINESSES() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
        BusinessDto dto1 = new BusinessDto("Walmart Corp.", date.parse("05-22-1997"), "mail@walmartcorp.com");
        BusinessDto dto2 = new BusinessDto("Home Hardware", date.parse("06-25-1993"), "mail@hware.com");
        BusinessDto dto3 = new BusinessDto("Home Furnish", date.parse("05-17-1977"), "mail@furnish.com");
        List<BusinessDto> dtoList = new ArrayList<>();
        dtoList.add(dto1);
        dtoList.add(dto2);
        dtoList.add(dto3);
        return dtoList;
    }

    public static List<UserAccountDto> USERS(List<BusinessDto> dtoList) throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");

        BusinessDto dto1 = new BusinessDto("Walmart Inc.", date.parse("05-10-1993"),"mail@walmart.com");
        BusinessDto dto2 = new BusinessDto("Home Depot", date.parse("11-10-1993"), "mail@hdepot.com");

        UserAccountDto user1 = new UserAccountDto("John", "Warren", dto1, "Admin", "password");
        UserAccountDto user2 = new UserAccountDto("John", "Warren", dto2, "Admin", "password");
        UserAccountDto user3 = new UserAccountDto("John", "Warren", dtoList.get(1), "Admin", "password");
        UserAccountDto user4 = new UserAccountDto("John", "Warren", dtoList.get(0),"Admin", "password");
        UserAccountDto user5 = new UserAccountDto("John", "Warren", dto1, "Staff", "password");
        UserAccountDto user6 = new UserAccountDto("John", "Warren", dtoList.get(2),"Staff", "password");

        List<UserAccountDto> userAccountDtoList = new ArrayList<>();
        userAccountDtoList.add(user3);
        userAccountDtoList.add(user4);
        userAccountDtoList.add(user1);
        userAccountDtoList.add(user2);
        userAccountDtoList.add(user5);
        userAccountDtoList.add(user6);

        return userAccountDtoList;
    }

    public static List<BrandDto> BRANDS(){
        List<BrandDto> brandDtos = new ArrayList<>();
        brandDtos.add(new BrandDto("Nike"));
        brandDtos.add(new BrandDto("Puma"));
        brandDtos.add(new BrandDto("Adidas"));
        brandDtos.add(new BrandDto("Converse"));
        brandDtos.add(new BrandDto("Polo"));
        return brandDtos;
    }

    public static List<CategoryDto> CATEGORIES(){
        List<CategoryDto> categoryDtos  = new ArrayList<>();
        categoryDtos.add(new CategoryDto("Shirts"));
        categoryDtos.add(new CategoryDto("Chinos"));
        categoryDtos.add(new CategoryDto("Jeans"));
        categoryDtos.add(new CategoryDto("Shorts"));
        categoryDtos.add(new CategoryDto("Vests"));
        categoryDtos.add(new CategoryDto("Accessories"));
        return categoryDtos;
    }

    public static List<ProductDto> PRODUCTS(List<BrandDto> brandDtos, List<CategoryDto> categoryDtos){
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto(1011, "Long Line T's", brandDtos.get(0), categoryDtos.get(0), 5, 29.99));
        productDtos.add(new ProductDto(1012, "Skinny Xs", brandDtos.get(1), categoryDtos.get(1), 15, 27.99));
        productDtos.add(new ProductDto(1013, "Slim Fit", brandDtos.get(2), categoryDtos.get(2), 11, 19.99));
        productDtos.add(new ProductDto(1014, "White Summer", brandDtos.get(3), categoryDtos.get(3), 25, 24.99));
        productDtos.add(new ProductDto(1015, "Beach V's", brandDtos.get(4), categoryDtos.get(4), 50, 25.99));
        productDtos.add(new ProductDto(1016, "Silver Ring", brandDtos.get(4), categoryDtos.get(5), 53, 29.99));
        return  productDtos;
    }
}
