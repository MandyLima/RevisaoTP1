package br.edu.fatecpg.revisao.view;
import br.edu.fatecpg.revisao.model.Aluno;
import br.edu.fatecpg.revisao.model.TreinamentoOnline;
import br.edu.fatecpg.revisao.model.TreinamentoPresencial;

public class MainTreinamento {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Frank", 10.0, 10);
        Aluno aluno2 = new Aluno("Isa", 8.0, 34);
        Aluno aluno3 = new Aluno("Amanda", 9.0, 55);

        TreinamentoPresencial treinamentoPresencial = new TreinamentoPresencial(1, "Alessandro", "Java", "Sala 101");
        TreinamentoOnline treinamentoOnline = new TreinamentoOnline(2, "Eulaliane", "Python", "www.treinamento.com");

        System.out.println(aluno1.getHorasEstudo());
        System.out.println(aluno2.getHorasEstudo());
        System.out.println(aluno3.getHorasEstudo());

        treinamentoPresencial.verificarDisponibilidade();
        treinamentoOnline.verificarDisponibilidade();
        treinamentoPresencial.definirCargaHoraria(120);
        treinamentoOnline.definirCargaHoraria(100);
        System.out.println(treinamentoPresencial.verificarUltimoTreinamento(aluno1));
        System.out.println(treinamentoOnline.verificarUltimoTreinamento(aluno2));
        treinamentoPresencial.calcularMediaAluno(aluno1);
        treinamentoOnline.calcularMediaAluno(aluno2);
        treinamentoPresencial.calcularMediaAluno(aluno3);
        treinamentoOnline.calcularMediaAluno(aluno3);

    }
}