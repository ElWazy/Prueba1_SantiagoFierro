package com.lutrias.prueba1_santiagofierro.context.shared.infrastructure;

import android.widget.TextView;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.Printer;

public final class Label implements Printer {
    private TextView label;

    public Label(TextView label) {
        this.label = label;
    }

    @Override
    public void print(String text) {
        label.setText(text);
    }
}
