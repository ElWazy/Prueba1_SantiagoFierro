package com.lutrias.prueba1_santiagofierro.context.vase.infrastructure;

import com.lutrias.prueba1_santiagofierro.context.vase.domain.AdditionalValue;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.Price;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.Vase;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.VaseRepository;
import com.lutrias.prueba1_santiagofierro.context.vase.domain.VaseType;

public final class InMemoryVaseRepository implements VaseRepository {
    private Vase[] vases;
    private VaseType[] types;
    private Price[] prices;
    private AdditionalValue[] additionalValues;

    public InMemoryVaseRepository() {
        this.vases = new Vase[3];
        types = new VaseType[]{
                new VaseType("Cerámica", 2),
                new VaseType("Porcelana", 3),
                new VaseType("Vidrio", 5)
        };

        prices = new Price[]{
                new Price(4500),
                new Price(12500),
                new Price(25000)
        };

        additionalValues = new AdditionalValue[]{
                new AdditionalValue(150),
                new AdditionalValue(350),
                new AdditionalValue(500)
        };

        for (int i = 0; i < vases.length; i++) {
            vases[i] = new Vase(
                    i,
                    types[i],
                    prices[i],
                    additionalValues[i]
            );
        }
    }

    @Override
    public Vase[] getAllVases() {
        return vases;
    }

    @Override
    public VaseType[] getAllTypes() {
        return types;
    }

    @Override
    public Price[] getAllPrices() {
        return prices;
    }

    @Override
    public AdditionalValue[] getAllAdditionalValues() {
        return additionalValues;
    }
}
