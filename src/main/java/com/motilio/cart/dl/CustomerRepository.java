package com.motilio.cart.dl;

import com.motilio.cart.domain.Customer;

public interface CustomerRepository {
    
    public Customer findCustomer(int customerId);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public Customer deleteCustomer(int customerId);

}
