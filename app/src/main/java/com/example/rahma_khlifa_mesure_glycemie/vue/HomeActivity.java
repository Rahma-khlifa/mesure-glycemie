package com.example.rahma_khlifa_mesure_glycemie.vue;

import static androidx.core.content.ContextCompat.startActivity;
import static org.antlr.v4.runtime.misc.MurmurHash.finish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rahma_khlifa_mesure_glycemie.R;
import com.example.rahma_khlifa_mesure_glycemie.contoller.HomeController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;
    private EditText etUserEmail;
    private EditText etPassword;
    private HomeController homeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        etUserEmail.setText(homeController.getUserEmail());

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail, password;
                boolean verifUserEmail = false, verifPassword = false;

                if (!etUserEmail.getText().toString().isEmpty())
                    if (!homeController.getUserEmail().equals("") && !etUserEmail.getText().toString().equals(homeController.getUserEmail()))
                        Toast.makeText(HomeActivity.this, "Email incorrect", Toast.LENGTH_LONG).show();
                    else
                        verifUserEmail = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre nom d'utilisateur !", Toast.LENGTH_SHORT).show();

                if (!etPassword.getText().toString().isEmpty())
                    if (!homeController.getUserEmail().equals("") && !etPassword.getText().toString().equals(homeController.getPassword()))
                        Toast.makeText(HomeActivity.this, "Mot de passe incorrect", Toast.LENGTH_LONG).show();
                    else
                        verifPassword = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre mot de passe !", Toast.LENGTH_LONG).show();

                if (verifPassword && verifUserEmail) {
                    userEmail = etUserEmail.getText().toString();
                    password = etPassword.getText().toString();
                    homeController.createUser(userEmail, password, HomeActivity.this);
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    private  void init(){

        homeController = homeController.getInstance(HomeActivity.this);
        btnConsultation = (Button) findViewById(R.id.btnConsultation);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUserEmail = (EditText) findViewById(R.id.etUserPassword);
    }

}