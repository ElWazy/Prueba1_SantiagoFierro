package com.lutrias.prueba1_santiagofierro.context.login.infrastructure;

import com.lutrias.prueba1_santiagofierro.context.login.domain.Password;
import com.lutrias.prueba1_santiagofierro.context.login.domain.User;
import com.lutrias.prueba1_santiagofierro.context.login.domain.UserRepository;
import com.lutrias.prueba1_santiagofierro.context.login.domain.Username;

public final class InMemoryUserRepository implements UserRepository {

    private User[] users;

    public InMemoryUserRepository() throws Exception {
        users = new User[]{
                new User(
                        new Username("Santiago"),
                        new Password("123")
                ),
                new User(
                        new Username("asdf"),
                        new Password("asdf")
                ),
                new User(
                        new Username("ElWazy"),
                        new Password("1234")
                )
        };
    }

    @Override
    public User[] getAll() {
        return users;
    }
}
