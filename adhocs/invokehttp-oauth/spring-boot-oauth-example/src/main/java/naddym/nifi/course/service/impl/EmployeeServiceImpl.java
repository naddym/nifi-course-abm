package naddym.nifi.course.service.impl;

import naddym.nifi.course.dto.EmployeeDTO;
import naddym.nifi.course.exception.ResourceNotFoundException;
import naddym.nifi.course.model.Employee;
import naddym.nifi.course.service.EmployeeService;
import naddym.nifi.course.utils.Converter;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    AtomicLong primaryKey = new AtomicLong(0L);
    ConcurrentHashMap<Long, Employee> employees = new ConcurrentHashMap<>();

    @Override
    public EmployeeDTO getEmployee(long id) {
        Employee employee = employees.get(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Unable to find employee.");
        }
        return Converter.employeeToEmployeeDTO(employee, id);
    }

    @Override
    public long addEmployee(EmployeeDTO employeeDTO) {
        Employee employee =Converter.employeeDtoToEmployee(employeeDTO);
        long id = primaryKey.incrementAndGet();

        employees.put(id, employee);
        return id;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = employees.remove(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Unable to find employee.");
        }
    }
}
