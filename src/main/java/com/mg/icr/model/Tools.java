package com.mg.icr.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    public Tools() {}

    public Tools(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
