package com.mg.icr.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tool", schema = "icr")
@Setter
@Getter
@ToString
@Builder
public class Tools {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tool_gen")
    @SequenceGenerator(name="tool_gen", schema = "icr", allocationSize = 1, sequenceName = "tool_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "team_tool",
            joinColumns = @JoinColumn(name = "tools_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;

    public Tools() {}

    public Tools(Integer id,String name, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.teams = teams;
    }
}
