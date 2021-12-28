/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untersuchung.services;

import untersuchung.domain.Account;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import untersuchung.dto.PersonDTO;
import untersuchung.repositories.AccountRepository;

/**
 *
 * @author lilith
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Optional<Account> registerAccount(Account registerRequest) throws Exception {
        Optional<Account> existingAccount = accountRepository.findByEmail(registerRequest.getEmail());
        if (!existingAccount.isPresent()) {
          
            Account save = accountRepository.save(registerRequest);
           
            return Optional.ofNullable(save);
        }
        return Optional.empty();
    }


}
