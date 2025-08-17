package com.manoelcampos.impostorenda;

public abstract class Pessoa {
    protected String nome;
    protected double salarioBruto;
    protected CalculoImpostoStrategy calculoImpostoStrategy;

    public Pessoa(String nome, double salarioBruto) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double calcularImpostoTotal() {
        return calculoImpostoStrategy.calcularImposto(this);
    }
}
