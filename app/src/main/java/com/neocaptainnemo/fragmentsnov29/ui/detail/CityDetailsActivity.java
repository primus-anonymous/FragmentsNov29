package com.neocaptainnemo.fragmentsnov29.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;

import com.neocaptainnemo.fragmentsnov29.R;
import com.neocaptainnemo.fragmentsnov29.domain.City;

public class CityDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_CITY = "EXTRA_CITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        } else {

            if (savedInstanceState == null) {
                FragmentManager fm = getSupportFragmentManager();

                City city = getIntent().getParcelableExtra(EXTRA_CITY);

                fm.beginTransaction()
                        .replace(R.id.container, CityDetailsFragment.newInstance(city))
                        .commit();
            }

        }
    }
}