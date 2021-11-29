package com.neocaptainnemo.fragmentsnov29.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import com.neocaptainnemo.fragmentsnov29.R;
import com.neocaptainnemo.fragmentsnov29.domain.City;
import com.neocaptainnemo.fragmentsnov29.ui.detail.CityDetailsActivity;
import com.neocaptainnemo.fragmentsnov29.ui.detail.CityDetailsFragment;
import com.neocaptainnemo.fragmentsnov29.ui.list.CitiesListFragment;

public class MainActivity extends AppCompatActivity /*implements CitiesListFragment.OnCityClicked*/ {

    private static final String ARG_CITY = "ARG_CITY";

    private City selectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(ARG_CITY)) {
            selectedCity = savedInstanceState.getParcelable(ARG_CITY);

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                showDetails();
            }
        }

        getSupportFragmentManager()
                .setFragmentResultListener(CitiesListFragment.RESULT_KEY, this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        selectedCity = result.getParcelable(CitiesListFragment.ARG_CITY);

                        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                            showDetails();
                        } else {
                            Intent intent = new Intent(MainActivity.this, CityDetailsActivity.class);
                            intent.putExtra(CityDetailsActivity.EXTRA_CITY, selectedCity);
                            startActivity(intent);
                        }
                    }
                });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (selectedCity != null) {
            outState.putParcelable(ARG_CITY, selectedCity);
        }
    }

    private void showDetails() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CityDetailsFragment.ARG_CITY, selectedCity);
        getSupportFragmentManager()
                .setFragmentResult(CityDetailsFragment.KEY_RESULT, bundle);
    }

    //    @Override
//    public void onCityClicked(City city) {
//        Intent intent = new Intent(this, CityDetailsActivity.class);
//        intent.putExtra(CityDetailsActivity.EXTRA_CITY, city);
//        startActivity(intent);
//
//    }
}