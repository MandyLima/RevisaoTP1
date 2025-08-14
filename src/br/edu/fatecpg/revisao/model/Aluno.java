package br.edu.fatecpg.revisao.model;

public class Aluno {
    String nome;
    double notaFinal;
    int horasEstudo;


    public Aluno(String nome, double notaFinal, int horasEstudo) {
        this.nome = nome;
        this.notaFinal = notaFinal;
        this.horasEstudo = horasEstudo;
    }

    public int getHorasEstudo() {
        return horasEstudo;
    }
}