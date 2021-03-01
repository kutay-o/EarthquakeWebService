package com.kutayondersev.earthquakeApp.data.repository;

import com.kutayondersev.earthquakeApp.data.entity.CountryInfo;
import org.springframework.data.repository.CrudRepository;

public interface ICountryInfoRepository extends CrudRepository<CountryInfo,String> {

}
