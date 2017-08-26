package com.mg.icr.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bonus_type", schema = "icr")
@Setter
@Getter
@ToString
@Builder
public class BonusType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bonus_type_gen")
    @SequenceGenerator(name = "bonus_type_gen", sequenceName = "bonus_type_id_seq",
            schema = "icr", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String type;

    public BonusType() {}

    public BonusType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

}
