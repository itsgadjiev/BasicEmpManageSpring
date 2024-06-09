package az.task.EmployeeManagement.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    public Long id;
    public String name;
    public String surname;
    public String email;
}
