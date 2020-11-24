package ru.perevozchikov.supervision.controller.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Event;
import ru.perevozchikov.supervision.service.EventService;
import ru.perevozchikov.supervision.service.user.EmployeeService;
import ru.perevozchikov.supervision.util.Utils;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController extends BasicDataController<Event, String> {
    private final EmployeeService employeeService;

    public EventController(EventService service, EmployeeService employeeService) {
        super(service);
        this.employeeService = employeeService;
    }

//    @GetMapping("/employee/{employeeId}")
//    public List<Event> getByEmployeeId(@PathVariable Integer employeeId) {
//       Employee employee = employeeService.getById(employeeId);
//        Utils.requireNonNull(employee);
//        return ((EventService) service).getByEmployee(employee);
//    }
}
