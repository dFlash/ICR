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
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", nullable = false)
    private String typeName;

}
