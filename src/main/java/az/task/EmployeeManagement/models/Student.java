package az.task.EmployeeManagement.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    private Long id;
    private String name;
    private String surname;
}
