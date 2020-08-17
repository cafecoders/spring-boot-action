package com.pan.Springbootaction.service;

import com.pan.Springbootaction.entity.Person;

public interface PersonService {
    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}
