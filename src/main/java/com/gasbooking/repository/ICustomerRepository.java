package com.gasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gasbooking.entity.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
