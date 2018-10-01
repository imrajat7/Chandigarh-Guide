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
public class PlacesFragment extends Fragment {

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of words
        final ArrayList<Location> places = new ArrayList<Location>();
        places.add(new Location(getString(R.string.places1_name), getString(R.string.places1_address), R.drawable.pinjore_gardens, getString(R.string.places1_description)));
        places.add(new Location(getString(R.string.places2_name), getString(R.string.places2_address), R.drawable.museum_and_art_gallery, getString(R.string.places2_description)));
        places.add(new Location(getString(R.string.places3_name), getString(R.string.places3_address), R.drawable.nada_sahib, getString(R.string.places3_description)));
        places.add(new Location(getString(R.string.places4_name), getString(R.string.places4_address), R.drawable.international_doll_museum, getString(R.string.places4_description)));
        places.add(new Location(getString(R.string.places5_name), getString(R.string.places5_address), R.drawable.chattbir_zoo, getString(R.string.places5_description)));
        places.add(new Location(getString(R.string.places6_name), getString(R.string.places6_address), R.drawable.terraced_garden, getString(R.string.places6_description)));
        places.add(new Location(getString(R.string.places7_name), getString(R.string.places7_address), R.drawable.cactus_gardens, getString(R.string.places7_description)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location location = places.get(position);
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