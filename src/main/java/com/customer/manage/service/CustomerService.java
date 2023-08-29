package com.customer.manage.service;

import java.util.List;

import com.manage.customer.entity.CustomerEntity;

public interface CustomerService {

	public void createCustomer(CustomerEntity customerEntity);

	public void updateCustomer(CustomerEntity customerEntity);

	public void deleteCustomer(int customerId);

	public CustomerEntity findByCustomerId(int customerId);

	public List<CustomerEntity> findByFirstName(String firstName);

	public List<CustomerEntity> findByLastNameAndMiddleName(String lastName, String middleName);

	public List<CustomerEntity> findByFirstNameOrLastName(String firstName, String lastName);

}