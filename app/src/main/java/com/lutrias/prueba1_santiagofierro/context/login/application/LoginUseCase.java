package com.lutrias.prueba1_santiagofierro.context.login.application;

import com.lutrias.prueba1_santiagofierro.context.login.domain.User;
import com.lutrias.prueba1_santiagofierro.context.login.domain.UserRepository;

public final class LoginUseCase {

    private User newUser;
    private UserRepository userRepo;

    public LoginUseCase(User user, UserRepository userRepo) {
        newUser = user;
        this.userRepo = userRepo;
    }


    public boolean userFound() {
        for (User user : userRepo.getAll()) {
            boolean match = user.equals(newUser);

            if (match) {
                return true;
            }
        }

        return false;
    }
}
