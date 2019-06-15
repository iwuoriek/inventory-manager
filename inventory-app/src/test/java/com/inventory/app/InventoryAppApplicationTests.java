package com.inventory.app;

import com.inventory.app.dto.*;
import com.inventory.app.model.Business;
import com.inventory.app.model.UserAccount;
import com.inventory.app.repository.*;
import com.inventory.app.service.*;
import com.inventory.app.utils.Required;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryAppApplicationTests {

	@Autowired private BusinessService businessService;
	@Autowired private UserAccountService userService;
	@Autowired private ProductService productService;
	@Autowired private BrandAndCategoryService brandAndCategoryService;
	@Autowired private SalesService salesService;
	@Autowired private BusinessRepository businessRepository;
	@Autowired private UserAccountRepository userRepository;
	@Autowired private BrandRepository brandRepository;
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private ProductRepository productRepository;
	@Autowired private SalesRepository salesRepository;

	private Date date;

	private static final Logger logger = LoggerFactory.getLogger(InventoryAppApplicationTests.class);

	@Before
	public void setUp() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		this.date = dateFormat.parse("05-22-1997");
	}

	@After
	public void tearDown() {
		this.date = null;
		userRepository.deleteAll();
		businessRepository.deleteAll();
		salesRepository.deleteAll();
		productRepository.deleteAll();
		brandRepository.deleteAll();
		categoryRepository.deleteAll();
	}

	@Test
	public void businessRegistrationSuccess() {
		logger.info("businessRegistrationSuccess");
		BusinessDto dto = new BusinessDto("Land Market Inc", this.date, "mail@lanmart.com");
		BusinessDto businessDto = businessService.registerBusiness(dto);
		Assert.assertNotNull(businessDto);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void businessRegistrationFailure() {
		logger.info("businessRegistrationFailure");
		BusinessDto dto = new BusinessDto("Dollarmart Inc", this.date, "mail@dollarmart.com");
		businessService.registerBusiness(dto);
		businessService.registerBusiness(dto);
	}

	@Test
	public void findBusinessByEmail() {
		logger.info("findBusinessByEmail");
		BusinessDto dto = new BusinessDto("FarmSales Inc", this.date, "mail@farmsales.com");
		businessService.registerBusiness(dto);
		BusinessDto businessDto = businessService.findByEmail("mail@farmsales.com");
		Assert.assertEquals("Business Reference", "BUS_FAR_REF", businessDto.getReference());
	}

	@Test
	public void userRegistrationForNewBusiness() {
		logger.info("userRegistrationForNewBusiness");
		BusinessDto businessDto = new BusinessDto("FarmSales Inc", this.date, "mail@farmsales.com");
		UserAccountDto userDto = new UserAccountDto("Tom", "Wells", businessDto, "Staff", "1234abcd");
		UserAccountDto dto = userService.registerNewUser(userDto);
		Assert.assertNotNull(dto);
	}

	@Test
	public void userRegistrationForExistingBusiness() {
		logger.info("userRegistrationForExistingBusiness");
		BusinessDto dto = new BusinessDto("Dollarmart Inc", this.date, "mail@dollarmart.com");
		BusinessDto businessDto = businessService.registerBusiness(dto);
		UserAccountDto userDto = new UserAccountDto("Tommy", "Han", businessDto, "Staff", "1234abcd");
		UserAccountDto userAccountDto = userService.registerNewUser(userDto);
		Assert.assertNotNull(userAccountDto);
	}

	@Test
	public void findUserSuccess() {
		logger.info("findUserSuccess");
		BusinessDto businessDto = new BusinessDto("Dollarmart Inc", this.date, "mail@dollarmart.com");
		UserAccountDto userDto = new UserAccountDto("Tommy", "Han", businessDto, "Staff", "1234abcd");
		userService.registerNewUser(userDto);
		UserAccountDto accountDto = userService.getUser("dol_than");
		Assert.assertEquals("Get users", accountDto.getFirstName(), "Tommy");
	}

	@Test(expected = NoSuchElementException.class)
	public void findUserFailure() {
		logger.info("findUserFailure");
		BusinessDto businessDto = new BusinessDto("Dollarmart Inc", this.date, "mail@dollarmart.com");
		UserAccountDto userDto = new UserAccountDto("Tommy", "Han", businessDto, "Staff", "1234abcd");
		userService.registerNewUser(userDto);
		UserAccountDto accountDto = userService.getUser("dol_jharriet");
	}

	@Test
	public void addProductTest(){
		logger.info("addProductTest");
		BrandDto brandDto = brandAndCategoryService.addBrand(Required.brandDto());
		CategoryDto categoryDto = brandAndCategoryService.addCategory(Required.categoryDto());
		ProductDto productDto = productService.addProduct(Required.productDto(brandDto, categoryDto));
		Assert.assertNotNull(productDto);
	}

	@Test
	public void updateProductTest(){
		logger.info("updateProductTest");
		BrandDto brandDto = brandAndCategoryService.addBrand(Required.brandDto());
		CategoryDto categoryDto = brandAndCategoryService.addCategory(Required.categoryDto());
		ProductDto productDto = productService.addProduct(Required.productDto(brandDto, categoryDto));
		productDto.setPrice(47.98);
		ProductDto newProductDdto = productService.updateProduct(productDto.getId(), productDto);
		Assert.assertEquals(47.98, newProductDdto.getPrice(), 0.0);
	}

	@Test(expected = NoSuchElementException.class)
	public void deleteProductTest(){
		logger.info("deleteProductTest");
		BrandDto brandDto = brandAndCategoryService.addBrand(Required.brandDto());
		CategoryDto categoryDto = brandAndCategoryService.addCategory(Required.categoryDto());
		ProductDto productDto = productService.addProduct(Required.productDto(brandDto, categoryDto));
		productService.deleteProduct(productDto.getId());
		productService.findProduct(productDto.getId());
	}

	@Test
	public void addSalesTest(){
		logger.info("addSalesTest");
		BrandDto brandDto = brandAndCategoryService.addBrand(Required.brandDto());
		CategoryDto categoryDto = brandAndCategoryService.addCategory(Required.categoryDto());
		Required.productDtoList(brandDto, categoryDto).forEach(productDto -> productService.addProduct(productDto));
		List<ProductDto> productDtos = productService.findAllProducts();

		SalesEntryDto entry1 = new SalesEntryDto(productDtos.get(0), 3, 129.00);
		SalesEntryDto entry2 = new SalesEntryDto(productDtos.get(1), 5, 120.00);
		SalesEntryDto entry3 = new SalesEntryDto(productDtos.get(2), 7, 150.00);
		SalesEntryDto entry4 = new SalesEntryDto(productDtos.get(3), 9, 129.00);

		SalesDto salesDto = new SalesDto( this.date, 2900.95);
		salesDto.getEntryDtos().add(entry1);
		salesDto.getEntryDtos().add(entry2);
		salesDto.getEntryDtos().add(entry3);
		salesDto.getEntryDtos().add(entry4);
		SalesDto dto = salesService.addSales(salesDto);
		Assert.assertNotNull(dto);
	}

	@Test
	public void getSalesTest(){
		logger.info("getSalesTest");
		BrandDto brandDto = brandAndCategoryService.addBrand(Required.brandDto());
		CategoryDto categoryDto = brandAndCategoryService.addCategory(Required.categoryDto());
		Required.productDtoList(brandDto, categoryDto).forEach(productDto -> productService.addProduct(productDto));
		List<ProductDto> productDtos = productService.findAllProducts();

		SalesEntryDto entry1 = new SalesEntryDto(productDtos.get(0), 3, 129.00);
		SalesEntryDto entry2 = new SalesEntryDto(productDtos.get(1), 5, 120.00);
		SalesEntryDto entry3 = new SalesEntryDto(productDtos.get(2), 7, 150.00);
		SalesEntryDto entry4 = new SalesEntryDto(productDtos.get(3), 9, 129.00);

		SalesDto salesDto = new SalesDto( this.date, 2900.95);
		salesDto.getEntryDtos().add(entry1);
		salesDto.getEntryDtos().add(entry2);
		salesDto.getEntryDtos().add(entry3);
		salesDto.getEntryDtos().add(entry4);
		salesService.addSales(salesDto);
		salesService.addSales(salesDto);
		salesService.addSales(salesDto);

		List<SalesDto> salesDtos = salesService.getAllSales();
		Assert.assertTrue(salesDtos.size() > 0);
	}

}
