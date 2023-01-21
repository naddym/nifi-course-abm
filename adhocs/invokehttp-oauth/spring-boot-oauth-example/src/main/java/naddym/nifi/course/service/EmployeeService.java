package naddym.nifi.course.service;

import naddym.nifi.course.dto.EmployeeDTO;

public interface EmployeeService {

    public EmployeeDTO getEmployee(long id);
    public long addEmployee(EmployeeDTO employee);
    public void deleteEmployee(long id);
}
