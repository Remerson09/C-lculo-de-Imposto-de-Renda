package com.manoelcampos.impostorenda;

public class CalculoImpostoPessoaJuridica implements CalculoImpostoStrategy {
    @Override
    public double calcularImposto(Pessoa pessoa) {
        if (!(pessoa instanceof PessoaJuridica)) {
            throw new IllegalArgumentException("Tipo de pessoa inválido para este cálculo de imposto.");
        }
        PessoaJuridica pj = (PessoaJuridica) pessoa;

        // Cálculo do IRPJ
        double irParcialPJ = pj.getLucro() * 0.15;
        double irExcedente = irParcialPJ - 20000;
        double irpj = irParcialPJ + (irExcedente > 0 ? irExcedente * 0.10 : 0);

        // Cálculo da CSLL
        double csll = pj.getLucro() * 0.09;

        // Cálculo do ICMS (considerando sobre o lucro para simplificação, conforme o problema)
        double icms = pj.getLucro() * 0.05;

        // O imposto total para PJ é IRPJ + CSLL + ICMS
        return irpj + csll + icms;
    }
}
