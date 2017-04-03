package com.example.joserenato.aula4;

/**
 * Created by JoseRenato on 03/04/2017.
 */

public class Professor extends Pessoa{
    private String salario;
    private String carga_horaria;

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
}
