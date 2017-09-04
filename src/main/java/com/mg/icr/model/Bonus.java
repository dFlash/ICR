package com.mg.icr.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "bonus", schema = "icr")
@Setter
@Getter
@ToString
@Builder
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bonus_gen")
    @SequenceGenerator(name="bonus_gen", schema = "icr", allocationSize = 1, sequenceName = "bonus_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "bonus_type_id")
    private BonusType bonusType;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Bonus() {}

    public Bonus(Integer id, String description, BonusType bonusType, Company company) {
        this.id = id;
        this.description = description;
        this.bonusType = bonusType;
        this.company = company;
    }

}
