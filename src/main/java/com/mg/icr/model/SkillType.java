package com.mg.icr.model;

import javax.persistence.*;

@Entity
@Table(name = "skill_type", schema = "icr")
public class SkillType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", nullable = false)
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "SkillType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
