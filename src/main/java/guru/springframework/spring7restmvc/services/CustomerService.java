package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer updateCustomer(UUID customerID, Customer customer);

    void deleteCustomer(UUID customerID);

    List<Customer> listCustomers();

    Customer getCustomerById(UUID id);

}
