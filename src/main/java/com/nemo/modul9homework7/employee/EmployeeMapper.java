package com.nemo.modul9homework7.employee;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @MapMapping(keyTargetType = String.class, valueTargetType = String.class)
    Employee toEntity(Map<String, String> params);


    @MapMapping(keyTargetType = String.class, valueTargetType = Object.class)
    Employee toEmployee(Map<String, Object> params);

    default String fromObjectToString(Object value){
        return String.valueOf(value);
    }
}
