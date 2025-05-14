package com.dev.phonebook.entity;

import com.dev.phonebook.enums.ContactType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@MappedSuperclass
public abstract class Contact {
    @Getter
    @Column(nullable = false, length = 50)
    private String firstName;
    @Getter
    @Column(nullable = false, length = 50)
    private String lastName;
    @Getter
    @Setter
    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Invalid phone number format"
    )
    @Column(nullable = false, length = 50, unique = true)
    private String phone;
    @Column(nullable = false, length = 100, unique = true)
    @Email(message = "Email should be valid")
    private String email;
    private Boolean isDeleted;
    @Getter
    private ContactType contactType;

    public void setFirstName(String firstName) {
        this.firstName = capitalizeFirstLetter(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = capitalizeFirstLetter(lastName);
    }

    public @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Contact(String firstName, String lastName, String phone, String email, ContactType contactType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.contactType = contactType;
        this.isDeleted = false;
    }

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isDeleted=" + isDeleted +
                ", contactType=" + contactType;
    }

    //region method
    private String capitalizeFirstLetter(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    //endregion
}
