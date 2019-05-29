package com.inventory.app.service;

import com.inventory.app.dto.BusinessDto;
import com.inventory.app.dto.UserAccountDto;
import com.inventory.app.model.UserAccount;
import com.inventory.app.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserAccountService {
    @Autowired
    private BusinessService service;
    @Autowired
    UserAccountRepository repository;

    public UserAccountDto registerNewUser(UserAccountDto userAccountDto){
        BusinessDto businessDto;
        UserAccount userAccount;
        try {
            businessDto = service.findByEmail(userAccountDto.getBusinessDto().getEmail());
            userAccountDto.setBusinessDto(businessDto);
            String username = generateUsername(userAccountDto.getFirstName(), userAccountDto.getLastName(),
                    businessDto.getReference(), 0);
            userAccountDto.setUsername(username);
            userAccountDto.setBusinessDto(businessDto);
            userAccount = repository.save(userAccountDto.toUserAccount());
            return toUserAccountDto(userAccount);

        } catch (NoSuchElementException e) {
            businessDto = service.registerBusiness(userAccountDto.getBusinessDto());
            String username = generateUsername(userAccountDto.getFirstName(), userAccountDto.getLastName(),
                    businessDto.getReference(), 0);
            userAccountDto.setUsername(username);
            userAccountDto.setBusinessDto(businessDto);
            userAccount = repository.save(userAccountDto.toUserAccount());
            return toUserAccountDto(userAccount);
        }
    }

    public UserAccountDto getUser(String username){
        UserAccount userAccount = repository.findByUsername(username)
                .orElseThrow(()->new NoSuchElementException("No entity found for user: " + username));
        return toUserAccountDto(userAccount);
    }

    public List<UserAccountDto> getUserList() {
        List<UserAccountDto> userAccountDtoList = new ArrayList<>();
        repository.findAll().forEach(userAccount -> userAccountDtoList.add(toUserAccountDto(userAccount)));
        return userAccountDtoList;
    }

    private String generateUsername(String firstName, String lastName, String businessRef, int flag){
        String ref = businessRef.split("_")[1].toLowerCase();
        char initial = firstName.toLowerCase().charAt(0);
        StringBuilder username = new StringBuilder();
        if(flag >= 1){
            username.append(ref).append("_").append(initial).append(lastName.toLowerCase()).append(flag);
        } else {
            username.append(ref).append("_").append(initial).append(lastName.toLowerCase());
        }
        if(exists(username.toString())) {
            flag += 1;
            return generateUsername(firstName, lastName, businessRef, flag);
        }
        return username.toString();
    }

    private boolean exists(String username){
        return repository.findByUsername(username).isPresent();
    }

    private UserAccountDto toUserAccountDto(UserAccount userAccount){

        return new UserAccountDto(userAccount.getUsername(), userAccount.getFirstName(),
                userAccount.getLastName(), service.toBusinessDto(userAccount.getBusiness()),
                userAccount.getRole(), userAccount.getPassword());
    }
}
