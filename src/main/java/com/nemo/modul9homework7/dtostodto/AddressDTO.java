package com.nemo.modul9homework7.dtostodto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    private String city;
    private String street;
}
