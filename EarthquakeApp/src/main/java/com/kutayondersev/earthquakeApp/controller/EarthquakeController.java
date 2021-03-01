package com.kutayondersev.earthquakeApp.controller;

import com.kutayondersev.earthquakeApp.service.EarthquakeService;
import com.kutayondersev.earthquakeApp.viewmodel.CountryViewModel;
import com.kutayondersev.earthquakeApp.viewmodel.EarthquakeViewModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/earthquake")
public class EarthquakeController {
    private final EarthquakeService m_earthquakeService;

    public EarthquakeController(EarthquakeService earthquakeService) {
        m_earthquakeService = earthquakeService;
    }

    @GetMapping("/countryinfo")
    public CountryViewModel getCountryInfo(@RequestParam("country") String query)
    {
        return m_earthquakeService.findCountry(query);
    }


    @GetMapping("/countryinfo/earthquake")
    public EarthquakeViewModel getEarthquake(@RequestParam("country") String query)
    {
        return m_earthquakeService.findEarthquake(query);
    }


}
