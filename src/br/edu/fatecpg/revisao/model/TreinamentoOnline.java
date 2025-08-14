package br.edu.fatecpg.revisao.model;

public class TreinamentoOnline extends Treinamento{
    private String linkAcesso;

    // Construtor corrigido
    public TreinamentoOnline(int id, String nomeInstrutor, String linguagemEnsinada, String linkAcesso) {
        super(id, nomeInstrutor, linguagemEnsinada);
        this.linkAcesso = linkAcesso;
    }

}