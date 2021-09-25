package com.lutrias.prueba1_santiagofierro.context.vase.application;

import com.lutrias.prueba1_santiagofierro.context.client.domain.Client;
import com.lutrias.prueba1_santiagofierro.context.shared.domain.Printer;
import com.lutrias.prueba1_santiagofierro.context.shared.domain.Rater;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.Vase;

public final class CalculateFinalCostUseCase {
    private final String prefixAdditionalValue = "El adicional es: ";
    private final String prefixFinalCost = "El costo final es: ";

    private Client client;
    private Vase vase;

    public CalculateFinalCostUseCase(Client client, Vase vase) {
        this.client = client;
        this.vase = vase;
    }

    private String additionalValue() {
        return prefixAdditionalValue + vase.additionalValue();
    }

    private String finalCost() {
        int result = client.salary() - vase.cost();
        return prefixFinalCost + result;
    }

    public void calculate(Printer lblAdditional, Printer lblFinalCost, Rater ratingBar) {
        lblAdditional.print( additionalValue() );
        lblFinalCost.print( finalCost() );
        ratingBar.rate( vase.type().laborRating() );
    }

}
