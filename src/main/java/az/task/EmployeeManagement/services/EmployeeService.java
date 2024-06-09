package az.task.EmployeeManagement.services;


import az.task.EmployeeManagement.DTOs.EmployeeDto;
import az.task.EmployeeManagement.mappers.EmployeeMapper;
import az.task.EmployeeManagement.models.Employee;
import az.task.EmployeeManagement.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDto getEmployeeByEmail(String emailAddress) {
        var employee = employeeRepository.findByEmail(emailAddress);

        if (employee != null)
            return employeeMapper.toEmployeeDto(employee);
        else
            return null;

    }

    public List<EmployeeDto> getAllEmployees(String name, String surname) {
        List<Employee> filteredEmployees = employeeRepository.findAll()
                .stream()
                .filter(employee -> (name == null || employee.getName().contains(name)))
                .filter(employee -> (surname == null || employee.getSurname().contains(surname)))
                .collect(Collectors.toList());


        List<EmployeeDto> emps = filteredEmployees.stream()
                .map(EmployeeMapper.Instance::toEmployeeDto)
                .collect(Collectors.toList());

        return emps;


    }

    public Employee createEmployee(EmployeeDto employeeDTO) {
        var employee = employeeMapper.toEmployee(employeeDTO);
        employeeRepository.save(employee);
        return employee;


    }

    public void deleteEmployee(Long id) {
        var existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent())
            employeeRepository.deleteById(id);

    }


//    public Long updateEmployee(Long id, EmployeeDto employeeDTO) {
//        Optional<Employee> optionalExistingEmployee = employeeRepository.findById(id);
//
//        if (optionalExistingEmployee.isPresent()) {
//            Employee existingEmployee = optionalExistingEmployee.get();
//
//            existingEmployee.setName(employeeDTO.getName());
//            existingEmployee.setEmail(employeeDTO.getEmail());
//            existingEmployee.setSurname(employeeDTO.getSurname());
//
//            employeeRepository.save(existingEmployee);
//            return id;
//        }
//
//        return null;
//    }

    public Long updateEmployee(Long id, EmployeeDto employeeDTO) {
        Optional<Employee> optionalExistingEmployee = employeeRepository.findById(id);

        if (optionalExistingEmployee.isPresent()) {
            Employee existingEmployee = optionalExistingEmployee.get();

            existingEmployee = employeeMapper.toEmployee(employeeDTO);
            employeeRepository.save(existingEmployee);
            return id;
        }

        return null;
    }

}
