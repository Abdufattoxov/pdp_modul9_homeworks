package com.nemo.modul9homework7.sourcedestination;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MapperOfSourceDestination {

    @Mapping(target = "name", source = "Source.name")
    @Mapping(target = "description", source = "Source.description")
    Destination toDestination(Source source);

    @InheritInverseConfiguration
    Source toSource(Destination destination);

    @Mapping(target = "name", source = "Source.name")
    @Mapping(target = "description", source = "Source.description")
    List<Destination> toDestinationList(List<Source> sourceList);

    @InheritInverseConfiguration
    List<Source> toSourceList(List<Destination> destinations);


}
