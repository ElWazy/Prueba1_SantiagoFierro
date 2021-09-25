package com.lutrias.prueba1_santiagofierro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lutrias.prueba1_santiagofierro.context.login.application.LoginUseCase;
import com.lutrias.prueba1_santiagofierro.context.login.domain.Password;
import com.lutrias.prueba1_santiagofierro.context.login.domain.User;
import com.lutrias.prueba1_santiagofierro.context.login.domain.UserRepository;
import com.lutrias.prueba1_santiagofierro.context.login.domain.Username;
import com.lutrias.prueba1_santiagofierro.context.login.infrastructure.InMemoryUserRepository;

public class MainActivity extends MyGenericActivity {

    private EditText txtUsername, txtPassword;
    private Button btnLogin, btnGeneralCalculates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getComponents();
        setButtons();
    }

    @Override
    protected void getComponents() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin             = findViewById(R.id.btnLogin);
        btnGeneralCalculates = findViewById(R.id.btnGeneralCalculates);
    }

    @Override
    protected void setButtons() {
        btnLogin.setOnClickListener(this::login);
        btnGeneralCalculates.setOnClickListener(this::calculate);
    }

    private void login(View view) {

        try {
            Username username = new Username(
                String.valueOf(txtUsername.getText())
            );
            Password password = new Password(
                String.valueOf(txtPassword.getText())
            );
            User user = new User(username, password);
            UserRepository userRepo = new InMemoryUserRepository();
            LoginUseCase loginUseCase = new LoginUseCase(user, userRepo);
            if (loginUseCase.userFound()) {
                goToActivity(Jarrones_act.class);
                txtUsername.setText("");
                txtPassword.setText("");
                return;
            }

            Toast.makeText(this, "No se encuentra el usuario", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void calculate(View view) {
        goToActivity(CalcularJarrones_act.class);
    }
}