package com.nemo.modul9homework7.dtostodto;

import lombok.*;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String id;
    private String name;
    private String surname;
    private String addressCity;
    private String addressStreet;
    private String passportID;
    private String passportNum;
}
