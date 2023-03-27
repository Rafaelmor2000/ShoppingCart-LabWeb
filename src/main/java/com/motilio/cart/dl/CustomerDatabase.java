package com.motilio.cart.dl;

import java.util.Map;

import com.motilio.cart.domain.*;

public class CustomerDatabase implements CustomerRepository {
    
    private Map<Integer, Customer> customers = Map.of(
        1, new Customer(1, "Marco", "Peña", "motilio@tec.mx", "555-555-5555"),
        2, new Customer(2, "Angeles", "Constantino", "aconstan@tec.mx", "555-555-5555")
    );

    @Override
    public Customer findCustomer(int customerId) {
        return customers.get(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCustomer'");
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    @Override
    public Customer deleteCustomer(int customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }
}
