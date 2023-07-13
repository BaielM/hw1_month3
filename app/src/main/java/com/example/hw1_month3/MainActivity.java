package com.example.hw1_month3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText inputEmail;
    private EditText inputTheme;
    private EditText inputMess;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_send);
        inputEmail = findViewById(R.id.et_inputEmail);
        inputTheme = findViewById(R.id.et_inputTheme);
        inputMess = findViewById(R.id.et_inputMess);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String to = inputEmail.getText().toString();
                String subject = inputTheme.getText().toString();
                String message = inputMess.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
    });
    }
}