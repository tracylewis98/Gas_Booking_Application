package com.gasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gasbooking.entity.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {


	@Query("select c from Customer c where c.username=:user and c.password=:pass")
	public Customer findByUsernameAndPassword(@Param("user") String username, @Param("pass") String Password);
}
