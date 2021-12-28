package untersuchung.resources;

import untersuchung.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import untersuchung.domain.Account;
import org.springframework.http.MediaType;

/**
 *
 * @author lilith
 */
@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PutMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    @Transactional
    public ResponseEntity<?> register(
            @RequestBody(required = true) Account registerRequest
    ) throws Exception {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {
          
            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }

}
