package com.neocaptainnemo.fragmentsnov29.ui.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.neocaptainnemo.fragmentsnov29.R;
import com.neocaptainnemo.fragmentsnov29.domain.City;
import com.neocaptainnemo.fragmentsnov29.domain.InMemoryCitiesRepository;
import com.neocaptainnemo.fragmentsnov29.ui.detail.CityDetailsActivity;

import java.util.List;

public class CitiesListFragment extends Fragment implements CitiesListView {

//    public interface OnCityClicked {
//        void onCityClicked(City city);
//    }

    public static final String ARG_CITY = "ARG_CITY";
    public static final String RESULT_KEY = "CitiesListFragment_RESULT";

    private LinearLayout citiesContainer;

    private CitiesListPresenter presenter;

//    private OnCityClicked onCityClicked;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        if (context instanceof OnCityClicked) {
//            onCityClicked = (OnCityClicked) context;
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        onCityClicked = null;
//        super.onDetach();
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new CitiesListPresenter(this, new InMemoryCitiesRepository());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cisites_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        citiesContainer = view.findViewById(R.id.cities_container);

        presenter.refresh();
    }

    @Override
    public void showCities(List<City> cities) {

        for (City city : cities) {

            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_city, citiesContainer, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle data = new Bundle();
                    data.putParcelable(ARG_CITY, city);

                    getParentFragmentManager()
                            .setFragmentResult(RESULT_KEY, data);

//                    if (onCityClicked != null) {
//                        onCityClicked.onCityClicked(city);
//                    }
                }
            });

            TextView cityTitle = itemView.findViewById(R.id.city_title);
            cityTitle.setText(city.getTitle());

            citiesContainer.addView(itemView);
        }

    }
}
