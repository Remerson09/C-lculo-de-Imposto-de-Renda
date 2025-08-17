package com.manoelcampos.impostorenda;

public class PessoaJuridica extends Pessoa {
    private double lucro;

    public PessoaJuridica(String nome, double salarioBruto, double lucro) {
        super(nome, salarioBruto);
        this.lucro = lucro;
        this.calculoImpostoStrategy = new CalculoImpostoPessoaJuridica();
    }

    public double getLucro() {
        return lucro;
    }
}
