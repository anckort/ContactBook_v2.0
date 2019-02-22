package com.test.ContactBook.entities;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contacts")
@Data
public class Contact {
    @Id
    @Column(name = "contacts_id")
    @SequenceGenerator(name = "contacts_seq", sequenceName = "contacts_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_seq")
    @Expose
    @Getter @Setter
    private Long id;

    @Column(name = "last_name")
    @Expose
    @Getter @Setter
    private String lastName;

    @Column(name = "first_name")
    @Expose
    @Getter @Setter
    private String firstName;

    @Column(name = "email")
    @Expose
    @Getter @Setter
    private String email;

    @OneToMany(mappedBy = "contactId", fetch = FetchType.EAGER)
    @Expose
    @Getter @Setter
    private List<PhoneNumber> phoneNumbers;


}
