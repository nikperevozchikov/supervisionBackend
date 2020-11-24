package ru.perevozchikov.supervision.repository;

import org.springframework.data.repository.CrudRepository;
import ru.perevozchikov.supervision.model.Employee;
import ru.perevozchikov.supervision.model.Organization;
import ru.perevozchikov.supervision.model.Position;

import java.time.LocalDateTime;
import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

    // Employee

    List<Organization> findByEmployee(Employee employee);

    //List<Organization> findByEmployeeAndDateTimeBetween(Employee employee, LocalDateTime from, LocalDateTime to);

   Organization findByName(String name);

}
