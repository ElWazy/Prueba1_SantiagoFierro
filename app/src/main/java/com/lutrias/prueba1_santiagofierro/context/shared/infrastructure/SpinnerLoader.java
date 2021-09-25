package com.lutrias.prueba1_santiagofierro.context.shared.infrastructure;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public final class SpinnerLoader<Model> {
    public SpinnerLoader(Context context, Model[] models, Spinner spinner) {
        ArrayAdapter adapter = new ArrayAdapter(
                context,
                android.R.layout.simple_list_item_1,
                models
        );

        spinner.setAdapter(adapter);
    }
}
