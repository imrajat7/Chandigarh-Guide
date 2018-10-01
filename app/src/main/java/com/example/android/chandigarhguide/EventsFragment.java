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
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of words
        final ArrayList<Location> events = new ArrayList<Location>();
        events.add(new Location(getString(R.string.event1_name), getString(R.string.event1_address), R.drawable.mdf, getString(R.string.event1_description)));
        events.add(new Location(getString(R.string.event2_name), getString(R.string.event2_address), R.drawable.sunburn_2018, getString(R.string.event2_description)));
        events.add(new Location(getString(R.string.event3_name), getString(R.string.event3_address), R.drawable.bacardi_nh7_weekender, getString(R.string.event3_description)));
        events.add(new Location(getString(R.string.event4_name), getString(R.string.event4_address), R.drawable.startup_weekend, getString(R.string.event4_description)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), events);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location location = events.get(position);
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