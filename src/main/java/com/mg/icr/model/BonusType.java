package com.mg.icr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "bonus_type", schema = "icr")
@Setter
@Getter
@ToString
public class BonusType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bonus_type_gen")
    @SequenceGenerator(name="bonus_type_gen", schema = "icr", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String type;
}
