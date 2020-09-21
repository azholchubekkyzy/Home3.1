package com.geektech.myhw311;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    private TextView text;

    private Button toSendToActiv2;
    private Button gmail;

    String textUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        text = findViewById(R.id.textView);
        gmail = findViewById(R.id.gmailSend);


        Intent intent = getIntent();


        imageView.setImageURI((Uri) getIntent().getParcelableExtra("img"));


        text.setText(getIntent().getStringExtra("Результат"));

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");

                // intent.setData(Uri.parse("test@gmail.com"));
                intent.putExtra(Intent.EXTRA_TEXT, text.getText());

                startActivity(Intent.createChooser(intent, "Share With"));


            }
        });

    }

    public void sendToActiv2(View view) {

        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(myIntent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4 && resultCode == RESULT_OK) {


        }
    }

}