package com.exam.cruds.Controller;


import com.exam.cruds.Model.AccountModel;
import com.exam.cruds.Repository.AccountRepository;
import com.exam.cruds.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private final AccountRepository repo = null;

    @GetMapping("/info")
    public String info() {

        return "Value from application prop ";

    }
    @GetMapping("/env")
    public String env() {

        return "Value from env ";

    }
    @GetMapping("/SelectAll")
    public List<AccountModel> SelectAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/Select/{accountid}")
    public AccountModel Select(@PathVariable int accountid){
        return repo.findByaccountid(accountid);
    }

    @PostMapping("/Save")
    public String Save(@RequestBody AccountModel account){
        repo.save(account);
        return "Saved successfully";
    }

    @PostMapping(path ="/Update")
    public String Update(@RequestBody AccountModel account) {
        try {
            AccountModel old=repo.findByaccountid(account.getAccountid());

            repo.delete(old);
           repo.save(account);
        }
        catch (Exception e ){
            return "error: there is issue while updating "+ e.getMessage();
        }
        return "Updated successfully";
    }




    @PostMapping(path ="/Delete/{accountid}")
    public String Delete(@PathVariable int accountid) {
        AccountModel Account=repo.findByaccountid(accountid);
         try {
             repo.delete(Account);
         }
         catch (Exception e ){

            return "error: there is issue while deleting ";

        }

       return "Delete successfully";
    }




}