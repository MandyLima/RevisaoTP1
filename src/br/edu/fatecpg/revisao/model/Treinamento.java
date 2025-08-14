package br.edu.fatecpg.revisao.model;
import br.edu.fatecpg.revisao.model.Aluno;
import java.util.*;

public class Treinamento {
    int id;
    String nomeInstrutor;
    String linguagemEnsinada;
    List<Aluno> alunos;
    boolean instrutorDisponivel = true;

    public Treinamento(int id, String nomeInstrutor, String linguagemEnsinada) {
        this.id = id;
        this.nomeInstrutor = nomeInstrutor;
        this.linguagemEnsinada = linguagemEnsinada;
        this.alunos = new ArrayList<>();
    }

    public void verificarDisponibilidade() {
        if(instrutorDisponivel) {
            System.out.println("O instrutor " + nomeInstrutor + " está disponível.");
        } else {
            System.out.println("O instrutor " + nomeInstrutor + " não está disponível.");
        }
    }

    public int definirCargaHoraria(int horas) {
        System.out.println("A carga horária definida é de " + horas + " horas.");
        return horas;
    }

    public String verificarUltimoTreinamento(Aluno aluno) {
        if(aluno.getHorasEstudo() < 80) {
            return "O aluno " + aluno.nome + " pode realizar o treinamento";
        }
        return "O aluno " + aluno.nome + " não pode realizar o treinamento, pois não cumpriu a carga horária mínima de 80 horas.";
    }

    public void calcularMediaAluno(Aluno aluno) {
        double media = aluno.notaFinal / 2;
        System.out.println("A média do aluno " + aluno.nome + " é: " + media);
    }
}