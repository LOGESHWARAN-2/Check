package com.example.Check.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String department;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("employee")
    private User user;

    @OneToMany(mappedBy = "assignedEmployee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("assignedEmployee")
    private List<Task> tasks;
}
