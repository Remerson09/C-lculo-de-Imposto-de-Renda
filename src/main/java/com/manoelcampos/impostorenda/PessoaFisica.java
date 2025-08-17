package com.manoelcampos.impostorenda;

public class PessoaFisica extends Pessoa {
    private int numeroDependentes;
    private double gastosSaude;
    private double gastosEducacao;

    public PessoaFisica(String nome, double salarioBruto, int numeroDependentes, double gastosSaude, double gastosEducacao) {
        super(nome, salarioBruto);
        this.numeroDependentes = numeroDependentes;
        this.gastosSaude = gastosSaude;
        this.gastosEducacao = gastosEducacao;
        this.calculoImpostoStrategy = new CalculoImpostoPessoaFisica();
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    public double getGastosEducacao() {
        return gastosEducacao;
    }
}
