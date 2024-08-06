package com.nemo.modul9homework7.employee;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private Long id;
    private String name;
    private String surname;
    private String createdAt;
}
