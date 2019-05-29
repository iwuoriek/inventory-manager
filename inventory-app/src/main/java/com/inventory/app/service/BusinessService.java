package com.inventory.app.service;

import com.inventory.app.dto.BusinessDto;
import com.inventory.app.model.Business;
import com.inventory.app.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusinessService {
    @Autowired
    BusinessRepository businessRepository;

    public BusinessDto registerBusiness(BusinessDto businessDto){
        int flag = 0;
        String reference = generateBusinessReference(businessDto.getName(), flag);
        businessDto.setReference(reference);
        Business business = businessRepository.save(businessDto.toBusiness());
        return toBusinessDto(business);
    }

    public BusinessDto findBusiness(String reference){
        Business business = businessRepository.findByReference(reference)
                .orElseThrow(()->new NoSuchElementException("No result found for ref: " + reference));
        return toBusinessDto(business);
    }

    public BusinessDto findByEmail(String email){
        Business business = businessRepository.findByEmail(email)
                .orElseThrow(()->new NoSuchElementException("No result for business email: " + email));
        return toBusinessDto(business);
    }

    public List<BusinessDto> findAllBusinesses(){
        List<BusinessDto> businessDtos = new ArrayList<>();
        businessRepository.findAll().forEach(business -> businessDtos.add(toBusinessDto(business)));
        return businessDtos;
    }

    private String generateBusinessReference(String name, int flag){
        String extract = name.substring(0, 3).toUpperCase();
        String reference;
        if (flag >= 1) {
            reference = "BUS_" + extract + flag + "_REF";
        } else {
            reference = "BUS_" + extract + "_REF";
        }
        if (exists(reference)) {
            flag += 1;
            return generateBusinessReference(name, flag);
        }
        return reference;
    }

    private boolean exists(String reference){
        return businessRepository.findByReference(reference).isPresent();
    }

    public BusinessDto toBusinessDto(Business business){
        BusinessDto businessDto = new BusinessDto(business.getReference(), business.getName(),
                business.getDateEstablished(), business.getEmail());
        businessDto.setId(business.getId());
        return businessDto;
    }
}
