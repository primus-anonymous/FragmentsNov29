package com.neocaptainnemo.fragmentsnov29.ui.list;

import com.neocaptainnemo.fragmentsnov29.domain.Callback;
import com.neocaptainnemo.fragmentsnov29.domain.CitiesRepository;
import com.neocaptainnemo.fragmentsnov29.domain.City;

import java.util.List;

public class CitiesListPresenter {

    private final CitiesListView view;

    private final CitiesRepository repository;

    public CitiesListPresenter(CitiesListView view, CitiesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void refresh() {

        view.showProgress();

        repository.getAllCities("cityName", new Callback<List<City>>() {
            @Override
            public void onSuccess(List<City> data) {
                view.showCities(data);
                view.hideProgress();
            }

            @Override
            public void onError(Throwable error) {
                view.hideProgress();
                view.showError(error.getMessage());

            }
        });

    }
}
