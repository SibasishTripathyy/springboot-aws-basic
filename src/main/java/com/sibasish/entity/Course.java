package com.sibasish.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "name")
    private String name;

    @Column(name = "credits")
    private Integer credits;

    @ManyToMany(mappedBy = "courseSet")
    private Set<Student> studentSet;
}
