package edu.eci.cvds.servlet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "CONFIGURATION")
public class Configuration {
    @Id
    @Column(name = "PROPIEDAD")
    private String id;
    @Column(name = "VALOR")
    private String valor;

    public Configuration(String id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Configuration() {

    }
    public void setId(String propiedad) {
        this.id = propiedad;
    }

    public String getId() {
        return id;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "ConfigutationB{" +
                "propiedad='" + id + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor);
    }
}