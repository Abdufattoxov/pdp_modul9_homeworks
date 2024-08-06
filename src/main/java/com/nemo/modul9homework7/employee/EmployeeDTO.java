package com.nemo.modul9homework7.employee;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private String firstName;
    private String secondName;
    private String createdAt;
}
