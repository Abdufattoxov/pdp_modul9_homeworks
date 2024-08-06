package com.nemo.modul9homework7.parsevalues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParsePropertyValues {
    @Value("${database.url}")
    public Object databaseURL;

    @Value("${database.username}")
    public Object databaseUsername;

    @Value("${database.password}")
    public Object databasePassword;
}
