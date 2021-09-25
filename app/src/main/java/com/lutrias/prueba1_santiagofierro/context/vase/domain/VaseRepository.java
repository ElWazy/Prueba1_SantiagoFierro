package com.lutrias.prueba1_santiagofierro.context.vase.domain;

public interface VaseRepository {
    public Vase[] getAllVases();
    public VaseType[] getAllTypes();
    public Price[] getAllPrices();
    public AdditionalValue[] getAllAdditionalValues();
}
