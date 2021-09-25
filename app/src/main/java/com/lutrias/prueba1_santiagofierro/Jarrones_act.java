package com.lutrias.prueba1_santiagofierro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.lutrias.prueba1_santiagofierro.context.client.domain.Client;
import com.lutrias.prueba1_santiagofierro.context.client.domain.ClientRepository;
import com.lutrias.prueba1_santiagofierro.context.client.infrastructure.InMemoryClientRepository;
import com.lutrias.prueba1_santiagofierro.context.shared.domain.Printer;
import com.lutrias.prueba1_santiagofierro.context.shared.domain.Rater;
import com.lutrias.prueba1_santiagofierro.context.shared.infrastructure.Label;
import com.lutrias.prueba1_santiagofierro.context.shared.infrastructure.MyRatingBar;
import com.lutrias.prueba1_santiagofierro.context.shared.infrastructure.SpinnerLoader;
import com.lutrias.prueba1_santiagofierro.context.vase.application.CalculateFinalCostUseCase;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.Vase;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.VaseRepository;
import com.lutrias.prueba1_santiagofierro.context.vase.infrastructure.InMemoryVaseRepository;

public class Jarrones_act extends MyGenericActivity {

    private Spinner spnClientName, spnVaseType;
    private TextView tvAdditional, tvFinalCost;
    private RatingBar ratingBar;
    private Button btnCalculateCost;

    private Printer lblAdditional, lblFinalCost;
    private Rater myRatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jarrones);

        getComponents();
        loadMyComponents();
        loadSpinners();
        setButtons();
    }

    @Override
    protected void getComponents() {
        spnClientName = findViewById(R.id.spnClientName);
        spnVaseType = findViewById(R.id.spnVaseType);

        tvAdditional = findViewById(R.id.lblAdditional);
        tvFinalCost = findViewById(R.id.lblFinalCost);

        ratingBar = findViewById(R.id.ratingBar);

        btnCalculateCost = findViewById(R.id.btnCalculateCost);
    }

    private void loadMyComponents() {
        lblAdditional = new Label(tvAdditional);
        lblFinalCost = new Label(tvFinalCost);

        myRatingBar = new MyRatingBar(ratingBar);
    }

    private void loadSpinners() {
        ClientRepository clientRepo = new InMemoryClientRepository();
        VaseRepository vaseRepo = new InMemoryVaseRepository();

        SpinnerLoader<Client> clientSpinnerLoader = new SpinnerLoader<>(
                this,
                clientRepo.getAll(),
                spnClientName
        );
        SpinnerLoader<Vase> vaseSpinnerLoader = new SpinnerLoader<>(
                this,
                vaseRepo.getAllVases(),
                spnVaseType
        );
    }

    @Override
    protected void setButtons() {
        btnCalculateCost.setOnClickListener(this::calculate);
    }

    private void calculate(View view) {
        CalculateFinalCostUseCase calculateFinalCost = new CalculateFinalCostUseCase(
                (Client) spnClientName.getSelectedItem(),
                (Vase) spnVaseType.getSelectedItem()
        );

        calculateFinalCost.calculate(lblAdditional, lblFinalCost, myRatingBar);
    }
}