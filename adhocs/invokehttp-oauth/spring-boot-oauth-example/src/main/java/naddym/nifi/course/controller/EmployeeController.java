package naddym.nifi.course.controller;

import naddym.nifi.course.dto.EmployeeDTO;
import naddym.nifi.course.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") String id) {
        EmployeeDTO employeeDTO = employeeService.getEmployee(Long.valueOf(id));
        return ResponseEntity.ok().body(employeeDTO);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> postEmployee(@RequestBody EmployeeDTO employeeDTO) {
        long id = employeeService.addEmployee(employeeDTO);
        EmployeeDTO saveEmployeeDTO = EmployeeDTO.builder()
                .id(id)
                .name(employeeDTO.getName())
                .age(employeeDTO.getAge())
                .address(employeeDTO.getAddress())
                .build();
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveEmployeeDTO);
    }


}
