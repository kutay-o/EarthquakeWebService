package com.kutayondersev.earthquakeApp.mapper;

import com.kutayondersev.earthquakeApp.data.entity.CountryInfo;
import com.kutayondersev.earthquakeApp.viewmodel.Geoname;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CountryMapperImpl",componentModel = "spring")
public interface ICountryMapper {
    Geoname toCountry(CountryInfo countryInfo);
    CountryInfo toCountryInfo(Geoname country);

}
