package com.kutayondersev.earthquakeApp.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Geoname {
    public String capital;
    public double south;
    public double north;
    public double east;
    public double west;
    public String countryCode;
    public String countryName;
    public String currencyCode;
}
