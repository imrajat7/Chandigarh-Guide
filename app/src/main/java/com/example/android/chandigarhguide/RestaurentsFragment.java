package com.example.android.chandigarhguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurentsFragment extends Fragment {

    public RestaurentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of words
        final ArrayList<Location> restaurents = new ArrayList<Location>();
        restaurents.add(new Location(getString(R.string.rest1_name), getString(R.string.rest1_address), R.drawable.garlic_greens, getString(R.string.rest1_description)));
        restaurents.add(new Location(getString(R.string.rest2_name), getString(R.string.rest2_address), R.drawable.virgin_courtyard, getString(R.string.rest2_description)));
        restaurents.add(new Location(getString(R.string.rest3_name), getString(R.string.rest3_address), R.drawable.cafe_jc, getString(R.string.rest3_description)));
        restaurents.add(new Location(getString(R.string.rest4_name), getString(R.string.rest4_address), R.drawable.swaghat_res, getString(R.string.rest4_description)));
        restaurents.add(new Location(getString(R.string.rest5_name), getString(R.string.rest5_address), R.drawable.ghazal_res, getString(R.string.rest5_description)));
        restaurents.add(new Location(getString(R.string.rest6_name), getString(R.string.rest6_address), R.drawable.shangrila, getString(R.string.rest6_description)));
        restaurents.add(new Location(getString(R.string.rest7_name), getString(R.string.rest7_address), R.drawable.chilli_pepper, getString(R.string.rest7_description)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), restaurents);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location location = restaurents.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("LOCATION", location);
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        return rootView;
    }

}