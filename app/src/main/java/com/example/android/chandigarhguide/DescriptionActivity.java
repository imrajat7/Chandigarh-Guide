package com.example.android.chandigarhguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView title;
    TextView description;
    ImageView imageID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        title = findViewById(R.id.description_title);
        description = findViewById(R.id.description_text);
        imageID = findViewById(R.id.description_image);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        Location location = (Location) bundle.getSerializable("LOCATION");

        assert location != null;
        title.setText(location.getLocationName());

        description.setText(location.getmDescription());
        imageID.setImageResource(location.getImageResourceId());
    }
}