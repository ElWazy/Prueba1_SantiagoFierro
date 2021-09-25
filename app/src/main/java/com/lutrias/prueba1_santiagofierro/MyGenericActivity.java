package com.lutrias.prueba1_santiagofierro;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public abstract class MyGenericActivity extends AppCompatActivity {
    protected abstract void getComponents();
    protected abstract void setButtons();
    protected void goToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
