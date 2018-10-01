package com.example.android.chandigarhguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of words
        final ArrayList<Location> attractions = new ArrayList<Location>();
        attractions.add(new Location(getString(R.string.attraction1_name), getString(R.string.attraction1_address), R.drawable.rock_garden, getString(R.string.attraction1_description)));
        attractions.add(new Location(getString(R.string.attraction2_name), getString(R.string.attraction2_address), R.drawable.sukhna_lake, getString(R.string.attraction2_description)));
        attractions.add(new Location(getString(R.string.attraction3_name), getString(R.string.attraction3_address), R.drawable.rose_garden, getString(R.string.attraction3_description)));
        attractions.add(new Location(getString(R.string.attraction4_name), getString(R.string.attraction4_address), R.drawable.elante_mall, getString(R.string.attraction4_description)));
        attractions.add(new Location(getString(R.string.attraction5_name), getString(R.string.attraction5_address), R.drawable.le_corbusier_centre, getString(R.string.attraction5_description)));
        attractions.add(new Location(getString(R.string.attraction6_name), getString(R.string.attraction6_address), R.drawable.sukhna_wildlife_sanctuary, getString(R.string.attraction6_description)));
        attractions.add(new Location(getString(R.string.attraction7_name), getString(R.string.attraction7_address), R.drawable.mohali_cricket_stadium, getString(R.string.attraction7_description)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), attractions);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location location = attractions.get(position);
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