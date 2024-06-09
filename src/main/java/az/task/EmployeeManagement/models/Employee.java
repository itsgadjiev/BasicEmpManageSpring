package az.task.EmployeeManagement.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
public class Employee {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String surname;
    public String email;

    public Employee() {
    }
}
