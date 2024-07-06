package br.projeto.sistemadeemprestimo.model;

public class Pessoa {

    private final String nome;
    private final String tel;
    private final String cpf;

    public Pessoa(String nome, String tel, String cpf) {
        this.nome = nome;
        this.tel = tel;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

     /*public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    } */

    public String getCpf() {
        return cpf;
    }

   /* public void setCpf(String cpf) {
        this.cpf = cpf;
    }*/

    @Override
    public String toString() {
        return "CPF: " + cpf + "Nome: " + nome + "Tel: " + tel;
    }
}
