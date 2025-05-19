package com.example.Contact_Manager.repositories;

import com.example.Contact_Manager.entities.Myuser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MyuserRepositories extends CrudRepository<Myuser ,Long> {
    Optional<Myuser>findByEmail(String username);
}
