package br.edu.fatecpg.revisao.model;

public class TreinamentoPresencial extends Treinamento {
    private String local;

    // Construtor corrigido
    public TreinamentoPresencial(int id, String nomeInstrutor, String linguagemEnsinada, String local) {
        super(id, nomeInstrutor, linguagemEnsinada);
        this.local = local;
    }

} 