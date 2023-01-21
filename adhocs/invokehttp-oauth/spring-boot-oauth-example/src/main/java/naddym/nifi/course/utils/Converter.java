package naddym.nifi.course.utils;

import naddym.nifi.course.dto.EmployeeDTO;
import naddym.nifi.course.model.Employee;

public class Converter {
    public static Employee employeeDtoToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .age(employeeDTO.getAge())
                .address(employeeDTO.getAddress())
                .build();
        return employee;
    }

    public static EmployeeDTO employeeToEmployeeDTO(Employee employee, long id) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(id)
                .name(employee.getName())
                .age(employee.getAge())
                .address(employee.getAddress())
                .build();
        return employeeDTO;
    }
}
