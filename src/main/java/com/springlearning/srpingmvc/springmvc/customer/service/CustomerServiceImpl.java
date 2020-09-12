package com.springlearning.srpingmvc.springmvc.customer.service;

import com.springlearning.srpingmvc.springmvc.customer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl {
    private Map<String, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        final Customer customer1 = new Customer();
        customer1.setId(UUID.randomUUID().toString());
        customer1.setFirstName("Priyojit");
        customer1.setLastName("Pal");
        customer1.setEmail("priyojit.pal@gmail.com");
        customer1.setAddress("06,Baguiati Road");
        customer1.setCity("Kolkata");
        customer1.setState("West Bengal");
        customer1.setPhone(7980621549L);
        customer1.setZipCode(700028);
        customers.put(customer1.getId(), customer1);

        final Customer customer2 = new Customer();
        customer2.setId(UUID.randomUUID().toString());
        customer2.setFirstName("Sagarika ");
        customer2.setLastName("Chanani");
        customer2.setEmail("chanani.sagarika@gmail.com");
        customer2.setAddress("Ashwingin Nagar,Baguiati");
        customer2.setCity("Kolkata");
        customer2.setState("West Bengal");
        customer2.setPhone(9051191331L);
        customer2.setZipCode(700091);
        customers.put(customer2.getId(), customer2);


        final Customer customer3 = new Customer();
        customer3.setId(UUID.randomUUID().toString());
        customer3.setFirstName("Rajesh");
        customer3.setLastName("De");
        customer3.setEmail("rajesh.de@gmail.com");
        customer3.setAddress("Behala");
        customer3.setCity("Kolkata");
        customer3.setState("West Bengal");
        customer3.setPhone(123456790L);
        customer3.setZipCode(700057);
        customers.put(customer3.getId(), customer3);


    }

    public List<Customer> listCustomers() {
        return customers.values().stream().collect(Collectors.toList());
    }

    public Customer getCustomeDetail(String customerId) {
        return customers.get(customerId);
    }

    public void saveOrUpdatCustomer(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("Customer  cannot be null");
        }
        if (customer.getId() == null || customer.getId().isEmpty()) {
            final String id = UUID.randomUUID().toString();
            customer.setId(id);
            customers.put(id, customer);
        } else {
            customers.replace(customer.getId(), customer);
        }

    }

    public void deletCustomer(String customerId) {
        if (customers.containsKey(customerId)) {
            customers.remove(customerId);
        } else {
            throw new RuntimeException("Invalid Customer Id");
        }
    }


}
