package az.task.EmployeeManagement.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDto {


    public Long id;
    public String name;
    public String surname;
    public String email;

    public EmployeeDto() {
    }
}
