package naddym.nifi.course.controller;

import naddym.nifi.course.dto.CustomerDTO;
import naddym.nifi.course.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") String id) {
        CustomerDTO customerDTO = customerService.getCustomer(Long.valueOf(id));
        return ResponseEntity.ok().body(customerDTO);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> postCustomer(@RequestBody CustomerDTO customerDTO) {
        long id = customerService.addCustomer(customerDTO);
        CustomerDTO saveCustomerDTO = CustomerDTO.builder()
                .id(id)
                .name(customerDTO.getName())
                .age(customerDTO.getAge())
                .address(customerDTO.getAddress())
                .zipCode(customerDTO.getZipCode())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCustomerDTO);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body("Customer successfully deleted");
    }
}
