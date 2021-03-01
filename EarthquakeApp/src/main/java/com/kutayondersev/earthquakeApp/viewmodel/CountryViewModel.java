package com.kutayondersev.earthquakeApp.viewmodel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryViewModel {
    private List<Geoname> m_geonames;

    public CountryViewModel()
    {}

    public CountryViewModel(List<Geoname> countries) {
        m_geonames = countries;
    }

    public List<Geoname> getGeonames() {
        return m_geonames;
    }

    public void setGeonames(List<Geoname> geonames) {
        this.m_geonames = geonames;
    }
}
