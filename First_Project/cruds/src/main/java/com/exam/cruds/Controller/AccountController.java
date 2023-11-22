package com.exam.cruds.Controller;


import com.exam.cruds.Model.AccountModel;
import com.exam.cruds.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private final AccountRepository repo = null;

    @GetMapping("/test")
    public List<AccountModel> test() {

        return repo.findAll();

    }
    @GetMapping("/book/{bookid}")
    public List<AccountModel> getBooks(@PathVariable("accountid") int accountid)
    {
        return booksService.getBooksById(bookid);
    }

    @GetMapping("/SelectAll")
    public String SelectAll() {
        return "SelectAll s";
    }

    @GetMapping("/Select")
    public String Select() {
        return "Select";
    }

    @PostMapping("/Save")
    public String Save() {
        return "Save";
    }

    @PostMapping("/Delete")
    public String Delete() {
        return "Delete";
    }
}