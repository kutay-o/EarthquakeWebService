package com.kutayondersev.earthquakeApp.service;

import com.kutayondersev.earthquakeApp.data.dal.EarthquakeHelper;
import com.kutayondersev.earthquakeApp.data.entity.CountryInfo;
import com.kutayondersev.earthquakeApp.mapper.ICountryMapper;
import com.kutayondersev.earthquakeApp.viewmodel.CountryViewModel;
import com.kutayondersev.earthquakeApp.viewmodel.EarthquakeViewModel;
import com.kutayondersev.earthquakeApp.viewmodel.Geoname;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class EarthquakeService {
    private final EarthquakeHelper m_earthquakeHelper;
    private final RestTemplate m_restTemplate;
    private final ICountryMapper m_countryMapper;

    @Value("${geonames.url.country}")
    private String m_urlCountry;

    @Value("${geonames.url.earthquake}")
    private String m_urlEarthquake;

    public EarthquakeService(EarthquakeHelper earthquakeHelper, RestTemplate restTemplate, ICountryMapper countryMapper) {
        m_earthquakeHelper = earthquakeHelper;
        m_restTemplate = restTemplate;
        m_countryMapper = countryMapper;
    }

    private CountryViewModel findCountryFromDB(String query)
    {
        var opt = m_earthquakeHelper.findCountryByCode(query);
        var ci = opt.orElseGet(() -> new CountryInfo(query));
        var obj = m_countryMapper.toCountry((CountryInfo) ci);
        var list = new ArrayList<Geoname>();
        list.add(obj);

        return new CountryViewModel(list);

    }
    private CountryViewModel findCountryFromGeo(String query)
    {
        var url = String.format(m_urlCountry,query);
        var countryViewModel = m_restTemplate.getForObject(url,CountryViewModel.class);


        if(countryViewModel != null)
        {
            countryViewModel.getGeonames().stream()
                    .map(m_countryMapper::toCountryInfo)
                    .forEach(i -> m_earthquakeHelper.countrySave(i));
        }

        return countryViewModel;
    }

    public CountryViewModel findCountry(String query)
    {
        return m_earthquakeHelper.existCountryByCode(query) ? findCountryFromDB(query) : findCountryFromGeo(query);
    }

    public EarthquakeViewModel findEarthquake(String query)
    {
        var country = findCountry(query);
        var S = country.getGeonames().get(0).south;
        var E = country.getGeonames().get(0).east;
        var W = country.getGeonames().get(0).west;
        var N = country.getGeonames().get(0).north;

        var url = String.format(Locale.US,m_urlEarthquake,N,S,E,W);
        var earthquakeViewModel = m_restTemplate.getForObject(url,EarthquakeViewModel.class);

        return earthquakeViewModel;
    }




}
