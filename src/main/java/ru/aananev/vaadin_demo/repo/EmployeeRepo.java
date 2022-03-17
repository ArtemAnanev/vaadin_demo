package ru.aananev.vaadin_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aananev.vaadin_demo.domain.Employee;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("from Employee e where concat(e.lastName, ' ', e.firstName, ' ', e.middleName)    like concat('%', :name, '%')"
    ) // собираем всех сотрудников в формате имя,фамилия,отчество
    List<Employee> findByName(@Param("name") String name);
}
