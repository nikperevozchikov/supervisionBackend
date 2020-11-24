package ru.perevozchikov.supervision.controller.data;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Organization;
import ru.perevozchikov.supervision.model.Role;
import ru.perevozchikov.supervision.service.OrganizationService;
import ru.perevozchikov.supervision.service.user.EmployeeService;
import ru.perevozchikov.supervision.util.Utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController extends BasicDataController<Organization, Integer> {
    private final EmployeeService employeeService;

    public OrganizationController(OrganizationService service, EmployeeService employeeService) {
        super(service);
        this.employeeService = employeeService;

    }

    @Override
    public List<Organization> getAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Role role = authentication.getAuthorities().stream().map(a -> Role.valueOf(a.getAuthority())).collect(Collectors.toList()).get(0);
        Integer userId = Integer.parseInt(((UserDetails) authentication.getPrincipal()).getUsername());
        List<Organization> organizations;
        switch (role) {
            case EMPLOYEE:
                organizations = getByEmployee(userId);
                break;

            case ADMIN:
                organizations = super.getAll();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
        return organizations;
    }

    /* Custom get requests */

    //Employee

    @GetMapping("/get/employee/{employeeId}")
    public List<Organization> getByEmployee(@PathVariable Integer employeeId) {
        Employee employee = employeeService.getById(employeeId);
        Utils.requireNonNull(employee);
        return ((OrganizationService) service).getByEmployee(employee);
    }

//    @GetMapping("/get/employee/datetime/{employeeId}")
//    public List<Organization> getByEmployeeAndDateTime(@PathVariable Integer employeeId,
//                                                       @RequestParam LocalDateTime from,
//                                                       @RequestParam LocalDateTime to) {
//        Employee employee = employeeService.getById(employeeId);
//        Utils.requireNonNull(employee);
//        return ((OrganizationService) service).getByEmployeeAndDateTimeBetween(employee, from, to);
//    }


}
