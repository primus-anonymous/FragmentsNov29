package com.neocaptainnemo.fragmentsnov29.domain;

import java.util.List;

public interface CitiesRepository {

    List<City> getAllCities();

    void addCity(City city);

    void removeCity(City city);

}
