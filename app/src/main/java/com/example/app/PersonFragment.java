package com.example.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class PersonFragment extends Fragment {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_READ = 2;
    private ImageView imageView;
    private Button loadPhoto;
    private Button takePhoto;

    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_person, container, false);

        imageView = rootView.findViewById(R.id.imageView2);
        loadPhoto = rootView.findViewById(R.id.loadPhotoBtn);
        takePhoto = rootView.findViewById(R.id.takePhotoBtn);

        EditText username, password;
        Button logout, update;
        DBHelper dbHelper;

        username = rootView.findViewById(R.id.userNameEditText);
        password = rootView.findViewById(R.id.passwordEditText);
        logout = rootView.findViewById(R.id.logoutBtn);
        update = rootView.findViewById(R.id.updateBtn);

        dbHelper = new DBHelper(getActivity());

        username.setText(OnLogin.user);
        password.setText(OnLogin.password);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString(); //you can't name both passowrds

                if(user.equals(OnLogin.user) && pass.equals(OnLogin.password))
                    Toast.makeText(getActivity(), "Credentials not changed", Toast.LENGTH_SHORT).show();
                else {
                    if(!user.equals(OnLogin.user)){
                        if(dbHelper.userExists(user)){
                            Toast.makeText(getActivity(), "Username already taken", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    boolean update = dbHelper.updateUsernamePassword(user, pass);
                    if(update) {
                        OnLogin.user = user;
                        OnLogin.password = pass;
                        Toast.makeText(getActivity(), "Credentials updated", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getActivity(), "Failed to update credentials", Toast.LENGTH_SHORT).show();
                }
//                Intent intent = new Intent(MainActivity.this, OnLogin.class);
//                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginPageActivity.class);
                startActivity(intent);
            }
        });

        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        loadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPictureGallery();
            }
        });


        return rootView;
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), "Error opening cam",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void openPictureGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_READ);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }

        if(requestCode==REQUEST_IMAGE_READ){
            Uri selectImage = data.getData();
            InputStream inputStream = null;
            try{
                assert selectImage != null;
                inputStream = getContext().getContentResolver().openInputStream(selectImage);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BitmapFactory.decodeStream(inputStream);
            imageView.setImageURI(selectImage);
        }
    }
}