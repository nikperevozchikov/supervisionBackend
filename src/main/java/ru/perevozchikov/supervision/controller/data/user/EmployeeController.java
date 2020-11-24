package ru.perevozchikov.supervision.controller.data.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Event;
import ru.perevozchikov.supervision.model.Organization;
import ru.perevozchikov.supervision.model.Position;
import ru.perevozchikov.supervision.service.EventService;
import ru.perevozchikov.supervision.service.OrganizationService;
import ru.perevozchikov.supervision.service.PositionService;
import ru.perevozchikov.supervision.service.user.EmployeeService;
import ru.perevozchikov.supervision.util.Utils;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController extends BasicUserController<Employee> {
    private final PositionService positionService;
    private final EventService eventService;

    public EmployeeController(EmployeeService service, PositionService positionService,
                              EventService eventService) {
        super(service);
        this.positionService = positionService;
        this.eventService = eventService;
    }

    @Override
    public Employee getById(@PathVariable Integer id) {
        Employee employee = super.getById(id);
        Utils.requireNonNull(employee);
        return employee;
    }

    @GetMapping("/get/position/{positionName}")
    public List<Employee> getByPosition(@PathVariable String positionName) {
        Position position = positionService.getByName(positionName);
        Utils.requireNonNull(position);
        return ((EmployeeService) service).getByPosition(position);
    }

//    @GetMapping("/get/event/{eventName}")
//    public List<Employee> getByEventName(@PathVariable String eventName) {
//        Event event = eventService.getByName(eventName);
//        Utils.requireNonNull(event);
//        return ((EmployeeService) service).getByEvent(event);
//    }
}
