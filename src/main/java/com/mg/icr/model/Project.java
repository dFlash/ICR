package com.mg.icr.model;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project", schema = "icr")
@Setter
@Getter
@ToString
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_gen")
    @SequenceGenerator(name="project_gen", schema = "icr", allocationSize = 1, sequenceName = "project_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "isactiv")
    private Boolean isactiv;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Project(Integer id, String name, String description, Date startDate, Date endDate, Boolean isactiv, Company company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isactiv = isactiv;
        this.company = company;
    }

    public Project() {
    }
}
