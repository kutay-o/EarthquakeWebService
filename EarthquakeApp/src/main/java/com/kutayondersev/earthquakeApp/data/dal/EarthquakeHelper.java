package com.kutayondersev.earthquakeApp.data.dal;

import com.kutayondersev.earthquakeApp.data.entity.CountryInfo;
import com.kutayondersev.earthquakeApp.data.repository.ICountryInfoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EarthquakeHelper {
    private final ICountryInfoRepository m_countryInfoRepository;

    public EarthquakeHelper(ICountryInfoRepository countryInfoRepository) {
        m_countryInfoRepository = countryInfoRepository;

    }

    public CountryInfo countrySave(CountryInfo countryInfo)
    {
        return m_countryInfoRepository.save(countryInfo);
    }
    public boolean existCountryByCode(String country)
    {
        return m_countryInfoRepository.existsById(country);
    }
    public Optional findCountryByCode(String country)
    {
        return m_countryInfoRepository.findById(country);
    }




}
