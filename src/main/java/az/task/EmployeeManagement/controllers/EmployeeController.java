package az.task.EmployeeManagement.controllers;


import az.task.EmployeeManagement.DTOs.EmployeeDto;
import az.task.EmployeeManagement.models.Employee;
import az.task.EmployeeManagement.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) String name,
                                                             @RequestParam(required = false) String surname) {
        List<EmployeeDto> employees = employeeService.getAllEmployees(name, surname);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/get/{emailAddress}")
    public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable String emailAddress) {
        return ResponseEntity.ok(employeeService.getEmployeeByEmail(emailAddress));
    }

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody EmployeeDto employeeDTO) {
        Employee createdEmployee = employeeService.createEmployee(employeeDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}