package com.neocaptainnemo.fragmentsnov29.domain;

import android.os.Handler;
import android.os.Looper;

import com.neocaptainnemo.fragmentsnov29.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class InMemoryCitiesRepository implements CitiesRepository{

    private Executor executor = Executors.newSingleThreadExecutor();

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void getAllCities(String query, Callback<List<City>> callback) {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                ArrayList<City> result = new ArrayList();

                result.add(new City(R.string.ebrg, R.drawable.ebrg));
                result.add(new City(R.string.msc, R.drawable.msc));
                result.add(new City(R.string.nsk, R.drawable.nsk));
                result.add(new City(R.string.sam, R.drawable.sam));
                result.add(new City(R.string.spb, R.drawable.spb));

                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        });

    }

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
