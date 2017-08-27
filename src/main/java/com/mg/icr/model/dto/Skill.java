package com.mg.icr.model.dto;

import com.mg.icr.model.SkillType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "skill", schema = "icr")
@Setter
@Getter
@ToString
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_gen")
    @SequenceGenerator(name="skill_gen", schema = "icr", allocationSize = 1, sequenceName = "skill_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private String level;

    @ManyToOne
    @JoinColumn(name = "skill_type_id")
    private SkillType skillType;

    public Skill() {}

    public Skill(Integer id, String name, String level, SkillType skillType) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.skillType = skillType;
    }
}
