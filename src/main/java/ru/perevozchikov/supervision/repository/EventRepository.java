package ru.perevozchikov.supervision.repository;

import org.springframework.data.repository.CrudRepository;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Event;
import ru.perevozchikov.supervision.model.Position;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, String> {

    //List<Event> findByEmployeesContains(Employee employee);

    List<Event> findByNameIn(List<String> ids);
   // Event findByName(String name);
}
