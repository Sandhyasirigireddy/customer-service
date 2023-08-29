
package com.customer.manage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.customer.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

	public List<CustomerEntity> findByFirstName(String firstName);
	
	public List<CustomerEntity> findByLastNameAndMiddleName(String lastName,String middleName);
	
	public List<CustomerEntity> findByFirstNameOrLastName(String firstName, String lastName);
}