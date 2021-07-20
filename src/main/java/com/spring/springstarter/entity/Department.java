package com.spring.springstarter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // we can now create a constructor that is not restricted on how much values we need to pass... ..even if we pass one parameter the constructor will still be valid
public class Department {

    @Id
    @SequenceGenerator(name = "department_seq", sequenceName = "department_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "department_seq")
    private Long departmentId;

    @NotBlank(message = "Department name is required.")
    @Length(min = 5, max = 50, message = "Department name should be between 5 and 50 characters long")
    private String departmentName;

    private String departmentAddress;

    @Length(min = 6, message = "Must be more than 4 characters long")
    private String departmentCode;
}
