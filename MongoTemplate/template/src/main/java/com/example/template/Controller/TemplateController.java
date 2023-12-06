package com.example.template.Controller;

import com.example.template.Repository.TemplateRepo;
import com.example.template.model.Templatemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Template")
public class TemplateController {
    @Autowired
    private final TemplateRepo repo = null;
    @GetMapping("/SelectAll")
    public List<Templatemodel> SelectAll(){
        return repo.findAll();
    }

    @GetMapping("/hello")
    public String hello(){
        return "New ";
    }
}
