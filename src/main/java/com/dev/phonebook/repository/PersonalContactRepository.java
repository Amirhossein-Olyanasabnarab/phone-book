package com.dev.phonebook.repository;

import com.dev.phonebook.entity.PersonalContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalContactRepository extends JpaRepository<PersonalContact, Long> {
}
