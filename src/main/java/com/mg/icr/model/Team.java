package com.mg.icr.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team", schema = "icr")
@Setter
@Getter
@ToString
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_gen")
    @SequenceGenerator(name="team_gen", schema = "icr", allocationSize = 1, sequenceName = "team_id_seq")

    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToMany
    @JoinTable(name = "team_tool",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "tools_id"))
    private List<Tools> teams;

    public Team(Integer id, String name, String description, Project project, List<Tools> teams) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.project = project;
        this.teams = teams;
    }

    public Team() {
    }
}
