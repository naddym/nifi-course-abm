package naddym.nifi.course.service;

import naddym.nifi.course.dto.CustomerDTO;

public interface CustomerService {
    public CustomerDTO getCustomer(long id);

    public long addCustomer(CustomerDTO customerDTO);

    public void deleteCustomer(long id);
}
