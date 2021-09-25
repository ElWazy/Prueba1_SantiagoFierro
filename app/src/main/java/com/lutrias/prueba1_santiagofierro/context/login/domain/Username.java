package com.lutrias.prueba1_santiagofierro.context.login.domain;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.StringValueObject;

public final class Username extends StringValueObject {

    private final int MINIMUM_CHARACTERS = 4;

    public Username(String value) throws Exception {
        super(value);

        if ( value.isEmpty() ) {
            throw new Exception("Nombre de usuario vacío.");
        }

        if ( !isValid() ) {
            throw new Exception("El nombre de usuario es demasiado corto.");
        }
    }

    private boolean isValid() {
        return value.length() >= MINIMUM_CHARACTERS;
    }

}
