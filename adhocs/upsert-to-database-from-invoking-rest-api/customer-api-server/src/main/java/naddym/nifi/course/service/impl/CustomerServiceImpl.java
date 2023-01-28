package naddym.nifi.course.service.impl;

import naddym.nifi.course.dto.CustomerDTO;
import naddym.nifi.course.exception.ResourceNotFoundException;
import naddym.nifi.course.model.Customer;
import naddym.nifi.course.service.CustomerService;
import naddym.nifi.course.utils.Converter;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerServiceImpl implements CustomerService {
    AtomicLong primaryKey = new AtomicLong(0L);
    ConcurrentHashMap<Long, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public CustomerDTO getCustomer(long id) {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Unable to find customer.");
        }
        return Converter.customerToCustomerDTO(customer, id);
    }

    @Override
    public long addCustomer(CustomerDTO customerDTO) {
        Customer customer = Converter.customerDtoToCustomer(customerDTO);
        long id = primaryKey.incrementAndGet();

        customers.put(id, customer);
        return id;
    }

    @Override
    public void deleteCustomer(long id) {
        Customer customer = customers.remove(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Unable to find customer.");
        }
    }
}
