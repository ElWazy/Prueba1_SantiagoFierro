package com.lutrias.prueba1_santiagofierro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.Printer;
import com.lutrias.prueba1_santiagofierro.context.shared.infrastructure.Label;
import com.lutrias.prueba1_santiagofierro.context.shared.infrastructure.SpinnerLoader;
import com.lutrias.prueba1_santiagofierro.context.vase.application.CalculatorUseCase;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.Vase;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.VaseRepository;
import com.lutrias.prueba1_santiagofierro.context.vase.infrastructure.InMemoryVaseRepository;

public class CalcularJarrones_act extends MyGenericActivity {

    private CheckBox[] checkBoxes;
    private Spinner spnVase;
    private TextView tvCalculatorResult;
    private Button btnCalculate;

    private Printer lblCalculatorResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_jarrones);

        getComponents();
        loadMyComponents();
        loadSpinners();
        setButtons();
    }

    @Override
    protected void getComponents() {
        checkBoxes = new CheckBox[2];
        checkBoxes[0] = findViewById(R.id.chb12Vases);
        checkBoxes[1] = findViewById(R.id.chb24Vases);

        spnVase = findViewById(R.id.spnVase);

        tvCalculatorResult = findViewById(R.id.lblCalculatorResult);

        btnCalculate = findViewById(R.id.btnCalculate);
    }

    private void loadMyComponents() {
        lblCalculatorResult = new Label(tvCalculatorResult);
    }

    private void loadSpinners() {
        VaseRepository vaseRepo = new InMemoryVaseRepository();
        SpinnerLoader<Vase> vaseSpinnerLoader = new SpinnerLoader<>(
                this,
                vaseRepo.getAllVases(),
                spnVase
        );
    }

    @Override
    protected void setButtons() {
        btnCalculate.setOnClickListener(this::calculate);
    }

    /**
     * Sacamos el valor numerico de un checkbox
     * tomando los 2 primeros charecteres del texto del mismo
     * @param checkBox el checkbox a procesar
     * @return los 2 primeros caracteres convertidos en un valor numerico
     */
    private int checkBoxValue(CheckBox checkBox) {
        String value = (String) checkBox
                .getText()
                .subSequence(0, 2);
        return Integer.parseInt(value);
    }

    private void calculate(View view) {
        int amount = 0;
        for (CheckBox checkBox: checkBoxes) {
            if (checkBox.isChecked())
                amount += checkBoxValue(checkBox);
        }

        CalculatorUseCase calculator = new CalculatorUseCase(
                (Vase) spnVase.getSelectedItem(),
                amount
        );

        calculator.calculate(lblCalculatorResult);
    }
}