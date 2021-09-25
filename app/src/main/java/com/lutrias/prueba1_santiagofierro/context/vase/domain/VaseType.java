package com.lutrias.prueba1_santiagofierro.context.vase.domain;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.StringValueObject;

public final class VaseType extends StringValueObject {
    private int laborRating;

    public VaseType(String value, int laborRating) {
        super(value);
        this.laborRating = laborRating;
    }

    public int laborRating() {
        return laborRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VaseType vaseType = (VaseType) o;

        return laborRating == vaseType.laborRating;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + laborRating;
        return result;
    }

    @Override
    public String toString() {
        return "VaseType{" +
                "value='" + value + '\'' +
                ", laborRating=" + laborRating +
                '}';
    }
}
