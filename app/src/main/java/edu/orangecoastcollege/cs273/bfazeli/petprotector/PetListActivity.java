package edu.orangecoastcollege.cs273.bfazeli.petprotector;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class PetListActivity extends AppCompatActivity {

    private ImageView petImageView;

    // This member variable stores the URI to whatever image has been selected
    // Default: none.png (R.drawable.none)
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        // Hook up the petImageView to the layout:
        petImageView = (ImageView) findViewById(R.id.petImageView);

        // Constructs a full URI to any Android resource (id, drawable, color, layout, etc)
        imageUri = getUriToResource(this, R.drawable.none);

        // Set the imageURI of the ImageView in code
        petImageView.setImageURI(imageUri);
    }

    public void selectPetImage(View view) {
        
    }
}
