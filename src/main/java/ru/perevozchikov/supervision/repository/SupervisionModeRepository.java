package ru.perevozchikov.supervision.repository;

import org.springframework.data.repository.CrudRepository;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.SupervisionMode;

import java.util.List;

public interface SupervisionModeRepository extends CrudRepository<SupervisionMode, String> {

   // List<SupervisionMode> findByEmployeesContains(Employee employee);

    List<SupervisionMode> findByNameIn(List<String> ids);

}
