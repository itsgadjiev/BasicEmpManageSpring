package az.task.EmployeeManagement.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Student {
    private Long id;
    private String name;
    private String surname;

    public Student() {
    }
}
