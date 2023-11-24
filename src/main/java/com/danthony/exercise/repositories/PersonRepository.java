package com.danthony.exercise.repositories;

import com.danthony.exercise.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.personId = ?1")
    Person findPersonByPersonId(int personId);

}
