package com.lutrias.prueba1_santiagofierro.context.client.domain;

import com.lutrias.prueba1_santiagofierro.context.shared.domain.IntegerValueObject;

public final class Client {
    private int id;
    private Name name;
    private Salary salary;

    public Client(int id, Name name, Salary salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int salary() {
        return salary.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (!name.equals(client.name)) return false;
        return salary.equals(client.salary);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + salary.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name.value();
    }

}
