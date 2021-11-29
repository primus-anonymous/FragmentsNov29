package com.neocaptainnemo.fragmentsnov29.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.neocaptainnemo.fragmentsnov29.R;
import com.neocaptainnemo.fragmentsnov29.domain.City;
import com.neocaptainnemo.fragmentsnov29.ui.list.CitiesListFragment;

public class CityDetailsFragment extends Fragment {
    public static final String ARG_CITY = "ARG_CITY";
    public static final String KEY_RESULT = "CityDetailsFragment_KEY_RESULT";
    private TextView cityTitle;
    private ImageView cityImage;

    public CityDetailsFragment() {
        super(R.layout.fragment_city_details);
    }

    public static CityDetailsFragment newInstance(City city) {
        CityDetailsFragment fragment = new CityDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cityTitle = view.findViewById(R.id.city_tile);

        cityImage = view.findViewById(R.id.city_image);

        if (getArguments() != null && getArguments().containsKey(ARG_CITY)) {
            displayDetails(getArguments().getParcelable(ARG_CITY));
        }

        getParentFragmentManager()
                .setFragmentResultListener(KEY_RESULT, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        City city = result.getParcelable(CitiesListFragment.ARG_CITY);

                        displayDetails(city);
                    }
                });
    }

    private void displayDetails(City city) {
        cityTitle.setText(city.getTitle());
        cityImage.setImageResource(city.getImage());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
