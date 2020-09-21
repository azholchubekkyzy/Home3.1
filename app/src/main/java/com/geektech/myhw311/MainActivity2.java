package com.geektech.myhw311;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static android.app.Notification.EXTRA_BACKGROUND_IMAGE_URI;
import static android.app.Notification.EXTRA_TEXT;

public class MainActivity2 extends AppCompatActivity {
    Uri save;
    public static final int PICK_IMAGE = 1;
    private EditText editText;

    private ImageView imageView;

    private Button to1Activ;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView2);
        to1Activ = findViewById(R.id.to1Activ);


        to1Activ.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                String text1 = editText.getText().toString();

                intent.putExtra("Результат", text1);

                intent.putExtra("img", imageUri);
                startActivity(intent);


            }


        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE);
                Bitmap image;


            }
        });


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        try {

            super.onActivityResult(requestCode, resultCode, resultData);
            if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
                if (resultData != null) {
                    // this is the image selected by the user
                    imageUri = resultData.getData();


                    imageView.setImageURI(imageUri);

                }
            }


        } catch (Exception e) {

        }
    }

}


