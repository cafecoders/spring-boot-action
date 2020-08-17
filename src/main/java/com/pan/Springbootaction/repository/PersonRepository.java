package com.pan.Springbootaction.repository;

import com.pan.Springbootaction.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
