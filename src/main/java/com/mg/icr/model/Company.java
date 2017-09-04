package com.mg.icr.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "company", schema = "icr")
@Setter
@Getter
@ToString
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_gen")
    @SequenceGenerator(name="company_gen", schema = "icr", allocationSize = 1, sequenceName = "company_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "owners", nullable = false)
    private String owners;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    public Company() {}

    public Company(Integer id, String description, String email, String phone) {
        this.id = id;
        this.description = description;
        this.email = email;
        this.phone = phone;
    }
}
