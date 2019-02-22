package com.test.ContactBook.entities;

import com.google.gson.annotations.Expose;
import lombok.Data;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;

@Entity
@Table(name = "phone_numbers")
@Data
public class PhoneNumber {
    @Id
    @Column(name = "phone_numbers_id")
    @SequenceGenerator(name = "phone_numbers_seq", sequenceName = "phone_numbers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_numbers_seq")
    @Expose
    private Long id;

    @Column(name = "operator_name")
    @Expose
    private String operatorName;

    @Column(name = "number")
    @Expose
    private String number;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    @Expose(serialize = false)
    private Contact contactId;

}
