package com.springlearning.srpingmvc.springmvc.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Declaring this class as controller makes Spring register its bean and treat it as a Spring MVC Controller
 * The @
 * */


@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
