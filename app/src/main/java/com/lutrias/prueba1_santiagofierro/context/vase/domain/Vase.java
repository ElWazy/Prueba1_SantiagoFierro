package com.lutrias.prueba1_santiagofierro.context.vase.domain;

public final class Vase {
    private int id;
    private VaseType type;
    private Price price;
    private AdditionalValue additionalValue;

    public Vase(int id, VaseType type, Price price, AdditionalValue additionalValue) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.additionalValue = additionalValue;
    }

    public int additionalValue() {
        return additionalValue.value();
    }

    public VaseType type() {
        return type;
    }

    public int calculate(int amount) {
       return price.value() * amount;
    }

    public int cost() {
        return price.value() + additionalValue.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vase vase = (Vase) o;

        if (id != vase.id) return false;
        if (!type.equals(vase.type)) return false;
        if (!price.equals(vase.price)) return false;
        return additionalValue.equals(vase.additionalValue);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + additionalValue.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return type.value();
    }

}
