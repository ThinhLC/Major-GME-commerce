package com.edu.poly.major.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Testcontroller {
@GetMapping("/test1")
    public String testing(){
        return "/templates/component/base.html";
    }
}
