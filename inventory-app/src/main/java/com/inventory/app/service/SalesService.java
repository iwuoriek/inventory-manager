package com.inventory.app.service;

import com.inventory.app.dto.SalesDto;
import com.inventory.app.dto.SalesEntryDto;
import com.inventory.app.model.Sales;
import com.inventory.app.repository.SalesEntryRepository;
import com.inventory.app.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private SalesEntryRepository entryRepository;
    @Autowired
    private ProductService service;

    public SalesDto addSales(SalesDto salesDto){
        SalesDto dto = new SalesDto(salesDto.getDate(), salesDto.getTotal());
        dto.setId(generateSalesId());
        salesDto.getEntryDtos().forEach(salesEntryDto -> {
            salesEntryDto.setSalesDto(dto);
            dto.getEntryDtos().add(salesEntryDto);
        });
        Sales sales = salesRepository.save(dto.toSales());
        return toSalesDto(sales);
    }

    public List<SalesDto> getAllSales(){
        List<SalesDto> salesDtos = new ArrayList<>();
        salesRepository.findAll().forEach(sales -> salesDtos.add(toSalesDto(sales)));
        return salesDtos;
    }

    public SalesDto getSales(String id){
        Sales sales = salesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No entity found for sale: " + id));
        return toSalesDto(sales);
    }

    private String generateSalesId(){
        int val = 1000000 + new Random().nextInt(999999);
        String salesId = "SL"+val;
        if(exists(salesId)){
            return generateSalesId();
        }
        return salesId;
    }

    private boolean exists(String id){
        return salesRepository.findById(id).isPresent();
    }

    public SalesDto toSalesDto(Sales sales){
        SalesDto salesDto = new SalesDto(sales.getDate(), sales.getTotal());
        salesDto.setId(sales.getId());
        sales.getEntries().forEach(salesEntry -> {
            SalesEntryDto entryDto = new SalesEntryDto(salesDto, service.toProductDto(salesEntry.getProduct()),
                    salesEntry.getQuantity(), salesEntry.getTotal());
            salesDto.getEntryDtos().add(entryDto);
        });
        return salesDto;
    }
}
