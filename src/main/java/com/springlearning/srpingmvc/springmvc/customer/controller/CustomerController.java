package com.springlearning.srpingmvc.springmvc.customer.controller;

import com.springlearning.srpingmvc.springmvc.customer.model.Customer;
import com.springlearning.srpingmvc.springmvc.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("/getCustomers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.listCustomers());
        return "customer";
    }

    @RequestMapping("/getCustomer/{customerId}")
    public String getCustomerDetail(@PathVariable String customerId, Model model) {
        model.addAttribute("customer", customerService.getCustomeDetail(customerId));
        return "customerDetail";

    }


    @RequestMapping("/addCustomer")
    public String addProduct(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    @RequestMapping("/saveCustomer")
    public String saveCustomer(Customer customer) {
        customerService.saveOrUpdatCustomer(customer);
        return "redirect:/getCustomers/";
    }

    @RequestMapping("/updateCustomer/{customerId}")
    public String updateCustomer(@PathVariable String customerId, Model model) {
        model.addAttribute("customer", customerService.getCustomeDetail(customerId));
        return "updateCustomer";
    }


    @RequestMapping("/editCustomer")
    public String editCustomer(Customer customer) {
        customerService.saveOrUpdatCustomer(customer);
        return "redirect:/getCustomers/";
    }


}
