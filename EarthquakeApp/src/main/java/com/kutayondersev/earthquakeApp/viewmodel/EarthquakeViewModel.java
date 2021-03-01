package com.kutayondersev.earthquakeApp.viewmodel;

import java.util.List;

public class EarthquakeViewModel
{
    private List<Earthquake> earthquakes;

    public EarthquakeViewModel()
    {}

    public EarthquakeViewModel(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }
}