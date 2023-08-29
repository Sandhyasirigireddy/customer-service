package com.customer.manage.serviceimpl;

 import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.manage.client.ProductClient;
import com.customer.manage.model.ProductModel;
import com.customer.manage.repository.CustomerRepository;
import com.customer.manage.service.CustomerService;
import com.customer.manage.service.ProductService;
import com.manage.customer.entity.ContactEntity;
import com.manage.customer.entity.CustomerEntity;

@Service
public class CustomerServiceImpl implements CustomerService ,ProductService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductClient productClient;

	@Override
	public void createCustomer(CustomerEntity customerEntity) {
		/*
		 * customerEntity.setContactList(customerEntity.getContactList().stream()
		 * .map(contact -> prepareContactEntity(contact,
		 * customerEntity.getCustomerId())) .collect(Collectors.toList()));
		 */

		customerRepository.save(customerEntity);
	}

	public ContactEntity prepareContactEntity(ContactEntity contactEntity, int customerId) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(customerId);
		contactEntity.setCustomerEntity(customerEntity);
		return contactEntity;
	}

	@Override
	public void updateCustomer(CustomerEntity customerEntity) {
		customerRepository.save(customerEntity);
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public CustomerEntity findByCustomerId(int customerId) {
		CustomerEntity customerEntity;

		Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(customerId);

		if (customerEntityOptional.isPresent()) {

			customerEntity = customerEntityOptional.get();
		} else {
			throw new RuntimeException(customerId + "--->Customer is not found");
		}

		return customerEntity;
	}

	@Override
	public List<CustomerEntity> findByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

	@Override
	public List<CustomerEntity> findByLastNameAndMiddleName(String lastName, String middleName) {
		return customerRepository.findByLastNameAndMiddleName(lastName, middleName);
	}

	@Override
	public List<CustomerEntity> findByFirstNameOrLastName(String firstName, String lastName) {
		return customerRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	@Override
	public ProductModel getProducts(int productId) {
		return productClient.findByProductId(productId);
	}

}
