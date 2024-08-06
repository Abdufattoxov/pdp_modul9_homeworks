package com.nemo.modul9homework7.entity;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;

@ParameterObject
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 120)
    @Parameter(description = "Store Name", required = true)
    private String name;

    @NotBlank
    @Size(min = 9, max = 250)
    @Parameter(description = "Store Email", required = true)
    private String email;

    @NotNull
    @Min(1)
    @Parameter(description = "Store EmployeeCount", required = true)
    private int employeeCount;

    @Parameter(description = "Store Description", required = false)
    private String desc;

    // getters and setters
}

