package com.kutayondersev.earthquakeApp.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class CountryInfo {
    @Id
    @Column(name = "country_code")
    public String countryCode;

    @Column(name = "capital")
    public String capital;

    @Column(name = "south")
    public double south;

    @Column(name = "north")
    public double north;

    @Column(name = "east")
    public double east;

    @Column(name = "west")
    public double west;

    @Column(name = "country_name")
    public String countryName;

    @Column(name = "currency_code")
    public String currencyCode;

    public CountryInfo()
    {}

    public CountryInfo(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getSouth() {
        return south;
    }

    public void setSouth(double south) {
        this.south = south;
    }

    public double getNorth() {
        return north;
    }

    public void setNorth(double north) {
        this.north = north;
    }

    public double getEast() {
        return east;
    }

    public void setEast(double east) {
        this.east = east;
    }

    public double getWest() {
        return west;
    }

    public void setWest(double west) {
        this.west = west;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
