package com.example.pj.contacts;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.pj.contacts.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        startFragment();
        startUniversalImageLoader();
    }

    private void startFragment(){
        //setting this fragment to replace whatever is active
        ContactsFragment contactsFragment = new ContactsFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentMain, contactsFragment);
        //back button to get the correct order
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private void startUniversalImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(MainActivity.this);
        ImageLoader.getInstance().init(universalImageLoader.getConfiguration());
    }
}
