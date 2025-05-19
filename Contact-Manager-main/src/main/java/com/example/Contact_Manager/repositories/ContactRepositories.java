package com.example.Contact_Manager.repositories;

import com.example.Contact_Manager.entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepositories extends CrudRepository<Contact ,Integer> {
}
