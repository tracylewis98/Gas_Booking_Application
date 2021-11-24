package com.gasbooking.service;

import java.util.InputMismatchException;
import java.util.List;

import com.gasbooking.entity.Customer;
import com.gasbooking.exception.CustomerNotFoundException;

public interface ICustomerService {

	public Customer insertCustomer(Customer customer);

	public Customer updateCustomer(Customer customer) throws InputMismatchException, CustomerNotFoundException;

	public Customer deleteCustomer(int customerId) throws InputMismatchException, CustomerNotFoundException;

	public List<Customer> viewCustomers() throws InputMismatchException, CustomerNotFoundException;

	public Customer viewCustomer(int customerId) throws InputMismatchException, CustomerNotFoundException;

}
