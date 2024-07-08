package br.projeto.sistemadeemprestimo.controller;

import br.projeto.sistemadeemprestimo.model.Pessoa;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ControllerEmprestimo   {

    private final double valor;
    private final int numParc;
    private int numParcPag;
    private final Pessoa pessoa;

    Scanner sc = new Scanner(System.in);

    Locale localBr = Locale.of("pt", "BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localBr);

    public ControllerEmprestimo(double valor, int numParc, int numParcPag, Pessoa pessoa) {
        this.valor = valor;
        this.numParc = numParc;
        this.numParcPag = numParcPag;
        this.pessoa = pessoa;
    }
    public void imprimirDados () {
        System.out.println("Nome: " +pessoa.getNome());
        System.out.println("Valor do Empréstimo: " + dinheiro.format(valor));
        System.out.println("Número de Parcelas: " + numParc);
        System.out.println("Número de Parcelas Pagas: " + numParcPag);
    }
    public  void pagarParcelas () {
        int parcelas = 0;
        String confirmapgto;
        double valorParc = valor / numParc;
        boolean validaParcelas = false;
        boolean validaPgto = false;

        while (!validaParcelas) {
            System.out.println(pessoa.getNome() + ", você possui " + (numParc - numParcPag) + " parcelas a serem pagas");
            try {
                System.out.println("Quantas parcelas deseja pagar hoje?: ");
                parcelas = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Carcetere inválido! Reinicie o sistema e tente novamente");
                System.exit(0);
            }
            if (parcelas >= 1 && parcelas <= (numParc - numParcPag)) {
                System.out.println("Você está prestes a pagar " + parcelas + " parcelas do seu empréstimo, " + pessoa.getNome() + "!");
                System.out.println("Você confirma o pagamento da(s) " + parcelas + " parcela(s)? Total a pagar: " + dinheiro.format(valorParc * parcelas));
                validaParcelas = true;
            } else {
                System.out.println("ATENÇÃO: O número de parcelas que podem ser pagas são: " + (numParc - numParcPag));
            }
        }
        while (!validaPgto) {
            System.out.println("Digite 'SIM' para confirmar e 'NAO' para cancelar");
            confirmapgto = sc.next();
            confirmapgto = confirmapgto.toUpperCase();
        switch (confirmapgto) {
            case "SIM": System.out.println("Pagamento confirmado com sucesso! ");
                //double pgto = valor / parcelas;
                numParcPag = numParcPag + parcelas;
                validaPgto = true;
            break;
            case "NAO": System.out.println("Tudo bem! Volte quando puder. :)");
                validaPgto = true;
                System.exit(0);
            break;
            default: System.out.println("Atenção: Escreva conforme orientado");
            break;
        }
            }
    }
    public void imprimirValorTotalPago () {
        System.out.println("Valor Total Pago (Acumulado): " + dinheiro.format( (valor/numParc) * numParcPag));
    }
    public void verificarEmprstimoQuitado () {
        if (numParc - numParcPag == 0) {
            System.out.println("Parabéns! Seu empréstimo está quitado!!");
        }
        else {
            System.out.println("Você ainda possui " + (numParc - numParcPag) + " a serem pagas\nAté Logo! ;)");
        }
    }
}