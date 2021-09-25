package com.lutrias.prueba1_santiagofierro.context.vase.application;

import android.annotation.SuppressLint;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.Printer;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.Vase;

import java.util.Locale;

public final class CalculatorUseCase {
    private Vase vase;
    private int amount;

    public CalculatorUseCase(Vase vase, int amount) {
        this.vase = vase;
        this.amount = amount;
    }

    // El SuppressLint es para que me deje de molestar el linter
    public void calculate(Printer lblResult) {
        @SuppressLint("DefaultLocale") String message = String.format(
                "Compraste %2d Jarrones de %s su costo es:\nEl resultado es: %d",
                amount,
                vase,
                vase.calculate(amount)
        );
        lblResult.print( message );

    }
}
