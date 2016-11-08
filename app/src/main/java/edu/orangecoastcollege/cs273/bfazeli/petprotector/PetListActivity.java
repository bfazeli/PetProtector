package edu.orangecoastcollege.cs273.bfazeli.petprotector;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PetListActivity extends AppCompatActivity {

    private ImageView petImageView;

    // This member variable stores the URI to whatever image has been selected
    // Default: none.png (R.drawable.none)
    private Uri imageUri;
    private static final int REQUEST_CODE_PHOTO = 100;
    private static final int REQUEST_CODE_CAMERA = 101;

    private DBHelper db;
    private EditText nameEditText, detailsEditText, phoneEditText;
    private ListView petListView;
    private List<Pet> pets;

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
        // List of all the permissions we need to request from user
        ArrayList<String> permList = new ArrayList<>();

        // Start by seeing if we have permission to camera
        int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (cameraPermission != PackageManager.PERMISSION_GRANTED)
            permList.add(Manifest.permission.CAMERA);

        // Next check to see if we have read external storage permission
        int readExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readExternalStoragePermission != PackageManager.PERMISSION_GRANTED)
            permList.add(Manifest.permission.READ_EXTERNAL_STORAGE);

        // Next check to see if we have write external storage permission
        int writeExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED)
            permList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        // If the list has items (size > 0), we need to request permissions from the user:
        if (permList.size() > 0)
        {
            // Convert the ArrayList into an Array of Strings
            String[] perms = new String[permList.size()];
            // Request permissions from the user
            ActivityCompat.requestPermissions(this, permList.toArray(perms), REQUEST_CODE_PHOTO);
        }

        // If we have all 3 permissions, open ImageGallery:
        if (cameraPermission == PackageManager.PERMISSION_GRANTED
                && readExternalStoragePermission == PackageManager.PERMISSION_GRANTED
                && writeExternalStoragePermission == PackageManager.PERMISSION_GRANTED)
        {
            // Use an Intent to launch gallery and take pictures
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, REQUEST_CODE_PHOTO);
        } else Toast.makeText(this,
                "Per protector requires camera and external storage permission",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Code to handle when the user closes the image gallery
        // (by selecting an image or pressing the back button).

        // The intent data is the URI selected from image gallery
        // Decide if the user selected an image:
        if (data != null && requestCode == REQUEST_CODE_PHOTO && resultCode == RESULT_OK) {
            // Set the imageURI to the data
            imageUri = data.getData();
            petImageView.setImageURI(imageUri);
        }
    }

    /**
     * Get uri to any resource type within an Android Studio project. Method is public static
     * to allow other classes to use it as a helper function.
     *
     * @param context The current context
     * @param resId   The resource identifier of the drawable
     * @return  Uri to resource by given id
     * @throws Resources.NotFoundException If the given resource id does not exist.
     */
    public static Uri getUriToResource(@NonNull Context context, @AnyRes int resId) throws Resources.NotFoundException {
        /**Return a Resources instance for your application's package. */
        Resources res = context.getResources();
        /** return URI */
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + res.getResourcePackageName(resId)
                + '/' + res.getResourceTypeName(resId)
                + '/' + res.getResourceEntryName(resId));
    }


}
