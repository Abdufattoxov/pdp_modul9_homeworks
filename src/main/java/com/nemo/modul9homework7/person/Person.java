package com.nemo.modul9homework7.person;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String id;
    private String name;
    private Integer age;
}
