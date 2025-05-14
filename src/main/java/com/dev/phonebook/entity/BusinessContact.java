package com.dev.phonebook.entity;

import com.dev.phonebook.enums.ContactType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "business_contact")
public class BusinessContact extends Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String job;

    public BusinessContact(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email, ContactType.BUSINESS_CONTACT);
    }

    public BusinessContact() {
        super(null, null, null, null, null);
    }

    @Override
    public String toString() {
        return "BusinessContact{" +
                "id= " + id +
                super.toString() +
                " , job='" + job + '\'' +
                '}';
    }
}
