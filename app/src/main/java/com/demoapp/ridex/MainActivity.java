package com.demoapp.ridex;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtLogIn;
    EditText edtName, edtUserName, edtEmail, edtPass, edtConfirmPass;
    Button btnCreateAccount;
    CheckBox edtCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogIn = findViewById(R.id.txt_log_in);
        edtName = findViewById(R.id.edt_name);
        edtUserName = findViewById(R.id.edt_user_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPass = findViewById(R.id.edt_pass);
        edtConfirmPass = findViewById(R.id.edt_confirm_pass);
        btnCreateAccount = findViewById(R.id.btn_create_acc);
        edtCheckBox = findViewById(R.id.edt_CheckBox);

        // Initially, disable the button and set its color
        btnCreateAccount.setEnabled(false);
        btnCreateAccount.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF673AB7"))); // Disabled state color

        edtCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Enable the button if the checkbox is checked, disable otherwise
            btnCreateAccount.setEnabled(isChecked);

            // Making the button "glow" (change color) when enabled
            if(isChecked) {
                btnCreateAccount.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#03DAC5")));
            }
            else {
                btnCreateAccount.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF673AB7")));
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, userName, email, pass, confirmPass;

                name = edtName.getText().toString();
                userName = edtUserName.getText().toString();
                email = edtEmail.getText().toString();
                pass = edtPass.getText().toString();
                confirmPass = edtConfirmPass.getText().toString();

                if(!name.isEmpty() && !userName.isEmpty() && !email.isEmpty() && !pass.isEmpty() && !confirmPass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Congrats!\nYou are an IUBATian Murgi", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Please, fillup the necessary info", Toast.LENGTH_SHORT).show();
                }

                edtName.setText("");
                edtUserName.setText("");
                edtEmail.setText("");
                edtPass.setText("");
                edtConfirmPass.setText("");
            }
        });


    }
}