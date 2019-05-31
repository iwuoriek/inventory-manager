package com.inventory.app.utils;

import com.inventory.app.dto.*;
import com.inventory.app.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BootStrap {
    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

    @Bean
    public CommandLineRunner runner(BusinessService service,
                                    UserAccountService accountService,
                                    BrandAndCategoryService bAndRService,
                                    ProductService productService,
                                    SalesService salesService){

        SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
        return (args) ->{
            service.registerBusiness(new BusinessDto("Walmart Corp.", date.parse("05-22-1997"), "mail@walmartcorp.com"));
            service.registerBusiness(new BusinessDto("Home Hardware", date.parse("06-25-1993"), "mail@hware.com"));
            service.registerBusiness(new BusinessDto("Home Furnish", date.parse("05-17-1977"), "mail@furnish.com"));

            USERS().forEach(userDto -> accountService.registerNewUser(userDto));
            BRANDS().forEach(brandDto -> bAndRService.addBrand(brandDto));
            CATEGORIES().forEach(categoryDto -> bAndRService.addCategory(categoryDto));

            logger.info("*************** BUSINESSES ***************");
            service.findAllBusinesses().forEach(businessDto -> logger.info(businessDto.toString()));

            logger.info("*************** USERS ***************");
            accountService.getUserList().forEach(user -> logger.info(user.toString()));

            logger.info("*************** BRANDS ***************");
            List<BrandDto> brandDtos = bAndRService.getBrands();
            brandDtos.forEach(brandDto -> logger.info(brandDto.toString()));

            logger.info("*************** CATEGORIES ***************");
            List<CategoryDto> categoryDtos = bAndRService.getCategories();
            categoryDtos.forEach(categoryDto -> logger.info(categoryDto.toString()));

            logger.info("*************** PRODUCTS ***************");
            PRODUCTS(brandDtos, categoryDtos).forEach(productDto -> productService.addProduct(productDto));
            List<ProductDto> productDtos = productService.findAllProducts();
            productDtos.forEach(productDto -> logger.info(productDto.toString()));

            logger.info("*************** SALES ***************");
            SalesDto salesDto = new SalesDto( date.parse("05-29-2019"), 2900.95);

            SalesEntryDto entry1 = new SalesEntryDto(productDtos.get(0), 3, 129.00);
            SalesEntryDto entry2 = new SalesEntryDto(productDtos.get(1), 5, 120.00);
            SalesEntryDto entry3 = new SalesEntryDto(productDtos.get(2), 7, 150.00);
            SalesEntryDto entry4 = new SalesEntryDto(productDtos.get(3), 9, 129.00);

            salesDto.getEntryDtos().add(entry1);
            salesDto.getEntryDtos().add(entry2);
            salesDto.getEntryDtos().add(entry3);
            salesDto.getEntryDtos().add(entry4);
            salesService.addSales(salesDto);
            salesService.addSales(salesDto);
            salesService.addSales(salesDto);

            List<SalesDto> salesDtos = salesService.getAllSales();

            salesDtos.forEach(salesDto1 -> {
                logger.info("*************** FETCHED SALES ***************");
                logger.info(salesDto1.toString());
                logger.info("*************** FETCHED ENTRIES ***************");
                salesDto1.getEntryDtos().forEach(salesEntryDto -> {
                    logger.info(salesEntryDto.toString());
                });
            });

        };
    }

    private static List<UserAccountDto> USERS() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
        UserAccountDto user1 = new UserAccountDto("John", "Warren",
                new BusinessDto("Walmart Inc.", date.parse("05-10-1993"),"mail@walmart.com"),
                "Admin", "password");

        UserAccountDto user2 = new UserAccountDto("John", "Warren",
                new BusinessDto("Home Depot", date.parse("11-10-1993"), "mail@hdepot.com"),
                "Admin", "password");

        UserAccountDto user3 = new UserAccountDto("John", "Warren",
                new BusinessDto("Home Hardware", date.parse("06-25-1993"), "mail@hware.com"),
                "Admin", "password");

        UserAccountDto user4 = new UserAccountDto("John", "Warren",
                new BusinessDto("Home Furnish", date.parse("05-17-1977"), "mail@furnish.com"),
                "Admin", "password");

        UserAccountDto user5 = new UserAccountDto("John", "Warren",
                new BusinessDto("Walmart Inc.", date.parse("05-10-1993"),"mail@walmart.com"),
                "Staff", "password");

        UserAccountDto user6 = new UserAccountDto("John", "Warren",
                new BusinessDto("Home Depot", date.parse("11-10-1993"), "mail@hdepot.com"),
                "Staff", "password");

        List<UserAccountDto> userAccountDtoList = new ArrayList<>();
        userAccountDtoList.add(user3);
        userAccountDtoList.add(user4);
        userAccountDtoList.add(user1);
        userAccountDtoList.add(user2);
        userAccountDtoList.add(user5);
        userAccountDtoList.add(user6);

        return userAccountDtoList;
    }

    private static List<BrandDto> BRANDS(){
        List<BrandDto> brandDtos = new ArrayList<>();
        brandDtos.add(new BrandDto("Nike"));
        brandDtos.add(new BrandDto("Puma"));
        brandDtos.add(new BrandDto("Adidas"));
        brandDtos.add(new BrandDto("Converse"));
        brandDtos.add(new BrandDto("Polo"));
        return brandDtos;
    }

    private static List<CategoryDto> CATEGORIES(){
        List<CategoryDto> categoryDtos  = new ArrayList<>();
        categoryDtos.add(new CategoryDto("Shirts"));
        categoryDtos.add(new CategoryDto("Chinos"));
        categoryDtos.add(new CategoryDto("Jeans"));
        categoryDtos.add(new CategoryDto("Shorts"));
        categoryDtos.add(new CategoryDto("Vests"));
        categoryDtos.add(new CategoryDto("Accessories"));
        return categoryDtos;
    }

    private static List<ProductDto> PRODUCTS(List<BrandDto> brandDtos, List<CategoryDto> categoryDtos){
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
