package com.example.marvelfanclub;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseClassName;
import java.io.File;

@ParseClassName("User")
public class Profile extends AppCompatActivity {
    private final String TAG = "Profile";
    ImageView ivProfile;
    TextView pUser;
    TextView fMovie;
    TextView fHero;
    TextView fScene;
    TextView fBio;

    public final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;
    public String photoFileName = "photo.jpg";
    private File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);

        ivProfile = findViewById(R.id.ivProfile);
        pUser = findViewById(R.id.pUser);
        fMovie = findViewById(R.id.fMovie);
        fHero = findViewById(R.id.fHero);
        fScene = findViewById(R.id.fScene);
        fBio = findViewById(R.id.fBio);
    }


    public static String KEY_PICTURE = "picture";
    public static String KEY_USERNAME = "username";
    public static String KEY_MOVIE = "movie";
    public static String KEY_HERO = "hero";
    public static String KEY_SCENE = "scene";
    public static String KEY_BIO = "bio";

    public String getKeyPicture(ImageView ivProfile) {
        KEY_PICTURE = this.ivProfile.toString();
        return KEY_PICTURE;
    }

    public String getKeyUsername(TextView pUser) {
        KEY_USERNAME = this.pUser.toString();
        return KEY_USERNAME;
    }

    public String getKeyMovie(TextView fMovie) {
        KEY_MOVIE = this.fMovie.toString();
        return KEY_MOVIE;
    }

    public String getKeyHero(TextView fHero) {
        KEY_HERO = this.fHero.toString();
        return KEY_HERO;
    }

    public String getKeyScene(TextView fScene) {
        KEY_SCENE = this.fScene.toString();
        return KEY_SCENE;
    }

    public String getKeyBio(TextView fBio) {
        KEY_BIO = this.fBio.toString();
        return KEY_BIO;
    }

    public void launchCamera() {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a File reference to access to future access
        photoFile = getPhotoFileUri(photoFileName);

        // wrap File object into a content provider
        // required for API >= 24
        // See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
        Uri fileProvider = FileProvider.getUriForFile(Profile.this, "com.codepath.fileprovider", photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // by this point we have the camera photo on disk
                Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
                // RESIZE BITMAP, see section below
                // Load the taken image into a preview
                ivProfile.setImageBitmap(takenImage);
            } else { // Result was a failure
                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Returns the File for a photo stored on disk given the fileName
    public File getPhotoFileUri(String fileName) {
        // Get safe storage directory for photos
        // Use `getExternalFilesDir` on Context to access package-specific directories.
        // This way, we don't need to request external read/write runtime permissions.
        File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
            Log.d(TAG, "failed to create directory");
        }

        // Return the file target for the photo based on filename
        File file = new File(mediaStorageDir.getPath() + File.separator + fileName);

        return file;
    }
}