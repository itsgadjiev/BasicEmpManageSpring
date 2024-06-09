package az.task.EmployeeManagement.mappers;


import az.task.EmployeeManagement.DTOs.EmployeeDto;
import az.task.EmployeeManagement.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper Instance = Mappers.getMapper(EmployeeMapper.class);

//    @Mapping(source = "email", target = "email")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "surname", target = "surname")
//    @Mapping(source = "id", target = "id")

    EmployeeDto toEmployeeDto(Employee employee);

//    @Mapping(source = "email", target = "email")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "surname", target = "surname")

    @Mapping(target = "id", ignore = true)
    Employee toEmployee(EmployeeDto addressDTO);
}
