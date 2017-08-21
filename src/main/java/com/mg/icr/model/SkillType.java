package com.mg.icr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "skill_type", schema = "icr")
@Setter
@Getter
@ToString
public class SkillType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_type_gen")
    @SequenceGenerator(name="skill_type_gen", schema = "icr", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", nullable = false)
    private String typeName;

}
