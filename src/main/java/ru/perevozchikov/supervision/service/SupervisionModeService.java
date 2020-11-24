package ru.perevozchikov.supervision.service;

import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Event;
import ru.perevozchikov.supervision.model.SupervisionMode;
import ru.perevozchikov.supervision.repository.EventRepository;
import ru.perevozchikov.supervision.repository.SupervisionModeRepository;

import java.util.List;

@Service
public class SupervisionModeService extends BasicDataService<SupervisionMode, String> {
    public SupervisionModeService(SupervisionModeRepository repository) {
        super(repository);
    }

//    public List<SupervisionMode> getByEmployee(Employee employee) {
//        return ((SupervisionModeRepository) repository).findByEmployeesContains(employee);
//    }

    public List<SupervisionMode> getByNameIn(List<String> names) {
        return ((SupervisionModeRepository) repository).findByNameIn(names);
    }
}

