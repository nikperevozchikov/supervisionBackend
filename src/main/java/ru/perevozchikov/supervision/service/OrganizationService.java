package ru.perevozchikov.supervision.service;

import org.springframework.stereotype.Service;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Organization;
import ru.perevozchikov.supervision.model.Position;
import ru.perevozchikov.supervision.model.SupervisionMode;
import ru.perevozchikov.supervision.repository.EventRepository;
import ru.perevozchikov.supervision.repository.OrganizationRepository;
import ru.perevozchikov.supervision.repository.PositionRepository;
import ru.perevozchikov.supervision.repository.SupervisionModeRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrganizationService extends BasicDataService<Organization, Integer> {
    public OrganizationService(OrganizationRepository repository) {
        super(repository);
    }
//    private final LocalDate startWorkingTime = LocalDate.of(Year.MIN_VALUE, 1, 1);
//    private final LocalDate endWorkingTime = LocalDate.of(Year.MAX_VALUE, 12, 31);
//    private final List<LocalTime> possibleOrganizationTimes = new ArrayList<>();

//    public OrganizationService(PatientTicketRepository repository) {
//        super(repository);
//        LocalTime possibleTime = startWorkingTime;
//        while (!possibleTime.isAfter(endWorkingTime)) {
//            possibleTicketTimes.add(possibleTime);
//            possibleTime = possibleTime.plusMinutes(30);
//        }
//    }

    public Organization getByName(String name) {
        return ((OrganizationRepository) repository).findByName(name);
    }
    public List<Organization> getByEmployee(Employee employee) {
        return ((OrganizationRepository) repository).findByEmployee(employee);
    }



//    public List<Organization> getByEmployeeAndDateTimeBetween(Employee employee, LocalDateTime from, LocalDateTime to) {
//        return ((OrganizationRepository) repository).findByEmployeeAndDateTimeBetween(employee, from, to);
//    }


}
