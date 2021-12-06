package com.neocaptainnemo.fragmentsnov29.domain;

import java.util.List;

public interface CitiesRepository {

    void getAllCities(String query, Callback<List<City>> callback);

    List<City> getAllCities();

    void addCity(City city);

    void removeCity(City city);

}
