package com.neocaptainnemo.fragmentsnov29.ui.list;

import com.neocaptainnemo.fragmentsnov29.domain.CitiesRepository;
import com.neocaptainnemo.fragmentsnov29.domain.City;

import java.util.List;

public class CitiesListPresenter {

    private CitiesListView view;

    private CitiesRepository repository;

    public CitiesListPresenter(CitiesListView view, CitiesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void refresh() {

        List<City> result = repository.getAllCities();

        view.showCities(result);
    }
}
