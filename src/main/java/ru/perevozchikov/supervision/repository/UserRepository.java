package ru.perevozchikov.supervision.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.perevozchikov.supervision.model.User;

@Repository
public interface UserRepository<T extends User> extends CrudRepository<T, Integer> {

    T findByPassportOrEmail(String passport, String email);
}
