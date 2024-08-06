package com.nemo.modul9homework7.dtostodto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
  PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

  @Mapping(target = "addressCity", source = "addressDTO.city")
  @Mapping(target = "addressStreet", source = "addressDTO.street")
  @Mapping(target = "passportID", source = "passportDTO.pid")
  @Mapping(target = "passportNum", source = "passportDTO.number")
  Person toEntity(PersonDTO personDTO, AddressDTO addressDTO, PassportDTO passportDTO);
}
