package az.task.EmployeeManagement.services;

import az.task.EmployeeManagement.DTOs.EmployeeDto;
import az.task.EmployeeManagement.models.Employee;
import az.task.EmployeeManagement.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeDto mapToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public Employee mapToEntity(EmployeeDto employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

    public EmployeeDto getEmployeeByEmail(String emailAddress) {
        var employee = employeeRepository.findByEmail(emailAddress);

        if (employee != null)
            return mapToDTO(employee);
        else
            return null;
    }

    public List<EmployeeDto> getAllEmployees(String name, String surname) {
         List<Employee> filteredEmployees = employeeRepository.findAll()
                .stream()
                .filter(employee -> (name == null || employee.getName().equals(name)))
                .filter(employee -> (surname == null || employee.getSurname().equals(surname)))
                .collect(Collectors.toList());

        return filteredEmployees.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    public Employee createEmployee(EmployeeDto employeeDTO) {
        var employee = mapToEntity(employeeDTO);
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Long id) {
        var existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent())
            employeeRepository.deleteById(id);

    }

    public Long updateEmployee(Long id, EmployeeDto employeeDTO) {
        Optional<Employee> optionalExistingEmployee = employeeRepository.findById(id);

        if (optionalExistingEmployee.isPresent()) {
            Employee existingEmployee = optionalExistingEmployee.get();

            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setEmail(employeeDTO.getEmail());
            existingEmployee.setSurname(employeeDTO.getSurname());

            return id;
        }

        return null;
    }

}
