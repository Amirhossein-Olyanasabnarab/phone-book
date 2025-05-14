package com.dev.phonebook.entity;

import com.dev.phonebook.enums.ContactType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personal_contact")
public class PersonalContact extends Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String address;

    public PersonalContact(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email, ContactType.PERSONAL_CONTACT);
    }

    public PersonalContact() {
        super(null, null, null, null, null);
    }


    @Override
    public String toString() {
        return "PersonalContact{" +
                "id= " + id +
                super.toString() +
                " , address='" + address + '\'' +
                '}';
    }
}
