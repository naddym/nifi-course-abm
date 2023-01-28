package naddym.nifi.course.utils;

import naddym.nifi.course.dto.CustomerDTO;
import naddym.nifi.course.model.Customer;

public class Converter {
    public static Customer customerDtoToCustomer(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .name(customerDTO.getName())
                .age(customerDTO.getAge())
                .address(customerDTO.getAddress())
                .zipCode(customerDTO.getZipCode())
                .build();
        return customer;
    }

    public static CustomerDTO customerToCustomerDTO(Customer customer, long id) {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(id)
                .name(customer.getName())
                .age(customer.getAge())
                .address(customer.getAddress())
                .zipCode(customer.getZipCode())
                .build();
        return customerDTO;
    }
}
