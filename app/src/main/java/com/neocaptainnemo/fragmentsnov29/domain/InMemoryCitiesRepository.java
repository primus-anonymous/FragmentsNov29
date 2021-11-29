package com.neocaptainnemo.fragmentsnov29.domain;

import com.neocaptainnemo.fragmentsnov29.R;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCitiesRepository implements CitiesRepository{
    @Override
    public List<City> getAllCities() {
        ArrayList<City> result = new ArrayList();

        result.add(new City(R.string.ebrg, R.drawable.ebrg));
        result.add(new City(R.string.msc, R.drawable.msc));
        result.add(new City(R.string.nsk, R.drawable.nsk));
        result.add(new City(R.string.sam, R.drawable.sam));
        result.add(new City(R.string.spb, R.drawable.spb));

        return result;
    }

    @Override
    public void addCity(City city) {

    }

    @Override
    public void removeCity(City city) {

    }
}
