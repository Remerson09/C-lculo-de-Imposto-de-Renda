package com.manoelcampos.impostorenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\nEscolha o tipo de pessoa para cálculo de imposto:");
            System.out.println("1. Pessoa Física");
            System.out.println("2. Pessoa Jurídica");
            System.out.println("0. Sair");
            System.out.print("Digite sua escolha: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Nome da Pessoa Física: ");
                    String nomePf = scanner.nextLine();
                    System.out.print("Salário Bruto: ");
                    double salarioBrutoPf = scanner.nextDouble();
                    System.out.print("Número de Dependentes: ");
                    int numDependentes = scanner.nextInt();
                    System.out.print("Gastos com Saúde: ");
                    double gastosSaude = scanner.nextDouble();
                    System.out.print("Gastos com Educação: ");
                    double gastosEducacao = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha

                    PessoaFisica pf = new PessoaFisica(nomePf, salarioBrutoPf, numDependentes, gastosSaude, gastosEducacao);
                    double impostoTotalPf = pf.calcularImpostoTotal();
                    System.out.println("Imposto Total para " + pf.getNome() + " (PF): R$ " + String.format("%.2f", impostoTotalPf));
                    break;
                case 2:
                    System.out.print("Nome da Pessoa Jurídica: ");
                    String nomePj = scanner.nextLine();
                    System.out.print("Lucro da Empresa: ");
                    double lucroPj = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha

                    PessoaJuridica pj = new PessoaJuridica(nomePj, 0.0, lucroPj); // Salário bruto não aplicável para PJ neste contexto
                    double impostoTotalPj = pj.calcularImpostoTotal();
                    System.out.println("Imposto Total para " + pj.getNome() + " (PJ): R$ " + String.format("%.2f", impostoTotalPj));
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);

        scanner.close();
    }
}