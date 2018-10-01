package com.example.android.chandigarhguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Location currentLocatioon = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView LocationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView AddressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);

        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        LocationTextView.setText(currentLocatioon.getLocationName());

        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        AddressTextView.setText(currentLocatioon.getLocationAddress());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_view);

        iconView.setImageResource(currentLocatioon.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}