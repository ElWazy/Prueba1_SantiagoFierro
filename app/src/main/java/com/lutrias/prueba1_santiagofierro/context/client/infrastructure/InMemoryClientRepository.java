package com.lutrias.prueba1_santiagofierro.context.client.infrastructure;

import com.lutrias.prueba1_santiagofierro.context.client.domain.Client;
import com.lutrias.prueba1_santiagofierro.context.client.domain.ClientRepository;
import com.lutrias.prueba1_santiagofierro.context.client.domain.Name;
import com.lutrias.prueba1_santiagofierro.context.client.domain.Salary;

public final class InMemoryClientRepository implements ClientRepository {
    private Client[] clients;
    private Name[] names;
    private Salary[] salaries;

    public InMemoryClientRepository() {
        this.clients = new Client[2];
        names = new Name[]{
                new Name("Sermieh"),
                new Name("Jacinta")
        };

        salaries = new Salary[]{
                new Salary(45000),
                new Salary(55000)
        };

        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client(
                    i,
                    names[i],
                    salaries[i]
            );
        }
    }

    @Override
    public Client[] getAll() {
        return clients;
    }
}
