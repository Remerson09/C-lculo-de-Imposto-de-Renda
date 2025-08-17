package com.manoelcampos.impostorenda;

public class CalculoImpostoPessoaFisica implements CalculoImpostoStrategy {
    @Override
    public double calcularImposto(Pessoa pessoa) {
        if (!(pessoa instanceof PessoaFisica)) {
            throw new IllegalArgumentException("Tipo de pessoa inválido para este cálculo de imposto.");
        }
        PessoaFisica pf = (PessoaFisica) pessoa;

        // Cálculo do INSS
        double inss = pf.getSalarioBruto() * 0.11;

        // Cálculo do IR Parcial
        double irParcial = (pf.getSalarioBruto() - (pf.getNumeroDependentes() * 189.59) - inss) * 0.11;

        // Cálculo do IR da PF
        double irPf = irParcial - (pf.getGastosSaude() + pf.getGastosEducacao());

        // O imposto total para PF é IR + INSS
        return irPf + inss;
    }
}
