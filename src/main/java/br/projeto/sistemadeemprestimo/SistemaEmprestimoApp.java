package br.projeto.sistemadeemprestimo;

import br.projeto.sistemadeemprestimo.controller.ControllerEmprestimo;
import br.projeto.sistemadeemprestimo.model.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEmprestimoApp {

    public static void main(String[] args) {
        String recebeCpf;

        Scanner sc = new Scanner(System.in);

        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();

        listaDePessoas.add(new Pessoa("Gabriel", "1194455475", "888.555.555-91"));
        listaDePessoas.add(new Pessoa("Jose", "1197575475", "348.555.555-82"));
        listaDePessoas.add(new Pessoa("Maria", "1197655475", "858.555.555-73"));
        listaDePessoas.add(new Pessoa("Joana", "11976745475", "788.555.555-64"));
        listaDePessoas.add(new Pessoa("Marcus", "1194497875", "898.555.555-55"));

        System.out.println("==================================================");
        System.out.println("=======BOAS VINDAS AO SISTEMA DE EMPRÉSTIMO=======");
        System.out.println("==================================================");

        System.out.println("Qual é o seu CPF? Digite no formato '000.000.000-00'");
        recebeCpf = sc.next();

        if (recebeCpf.equals(listaDePessoas.get(0).getCpf())) {

            ControllerEmprestimo emprestimo = new ControllerEmprestimo(50000,60, 5, listaDePessoas.get(0));

            emprestimo.imprimirDados();

            emprestimo.pagarParcelas();

            emprestimo.imprimirValorTotalPago();

            emprestimo.verificarEmprstimoQuitado();

        }
        if (recebeCpf.equals(listaDePessoas.get(1).getCpf())) {

            ControllerEmprestimo emprestimo = new ControllerEmprestimo(1000.85,10, 0, listaDePessoas.get(1));

            emprestimo.imprimirDados();

            emprestimo.pagarParcelas();

            emprestimo.imprimirValorTotalPago();

            emprestimo.verificarEmprstimoQuitado();

        }
        if (recebeCpf.equals(listaDePessoas.get(2).getCpf())) {

            ControllerEmprestimo emprestimo = new ControllerEmprestimo(350000,120, 50, listaDePessoas.get(2));

            emprestimo.imprimirDados();

            emprestimo.pagarParcelas();

            emprestimo.imprimirValorTotalPago();

            emprestimo.verificarEmprstimoQuitado();

        }
        if (recebeCpf.equals(listaDePessoas.get(3).getCpf())) {

            ControllerEmprestimo emprestimo = new ControllerEmprestimo(2000.90,5, 1, listaDePessoas.get(3));

            emprestimo.imprimirDados();

            emprestimo.pagarParcelas();

            emprestimo.imprimirValorTotalPago();

            emprestimo.verificarEmprstimoQuitado();

        }
        if (recebeCpf.equals(listaDePessoas.get(4).getCpf())) {

            ControllerEmprestimo emprestimo = new ControllerEmprestimo(4000.99,12, 2, listaDePessoas.get(4));

            emprestimo.imprimirDados();

            emprestimo.pagarParcelas();

            emprestimo.imprimirValorTotalPago();

            emprestimo.verificarEmprstimoQuitado();

        }
        if (!recebeCpf.equals(listaDePessoas.get(0).getCpf()) && !recebeCpf.equals(listaDePessoas.get(1).getCpf()) &&
                !recebeCpf.equals(listaDePessoas.get(2).getCpf()) &&
                !recebeCpf.equals(listaDePessoas.get(3).getCpf()) &&
                !recebeCpf.equals(listaDePessoas.get(4).getCpf())) {

            System.out.println("CPF não localizado! Entre em contato com o seu gerente");
        }
    }
}