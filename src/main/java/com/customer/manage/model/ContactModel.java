
package com.customer.manage.model;

public class ContactModel {

	private int contactId;

	private String contactType;

	private String value;
	private CustomerModel customerModel;

	public ContactModel() {
	}

	public ContactModel(int contactId, String contactType, String value, CustomerModel customerModel) {
		super();
		this.contactId = contactId;
		this.contactType = contactType;
		this.value = value;
		this.customerModel = customerModel;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	

}