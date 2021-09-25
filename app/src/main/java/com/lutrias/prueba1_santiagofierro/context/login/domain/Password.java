package com.lutrias.prueba1_santiagofierro.context.login.domain;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.StringValueObject;

public final class Password extends StringValueObject {

    private final int MINIMUM_CHARACTERS = 3;

    public Password(String value) throws Exception {
        super(value);
        if ( value.isEmpty() ) {
            throw new Exception("La contraseña está vacía.");
        }

        if ( !isValid() ) {
            throw new Exception("La contraseña es demasiado corta");
        }
    }

    private boolean isValid() {
        return value.length() >= MINIMUM_CHARACTERS;
    }

}
