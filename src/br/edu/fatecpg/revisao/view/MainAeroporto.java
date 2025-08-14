package br.edu.fatecpg.revisao.view;
import br.edu.fatecpg.revisao.model.Aeroporto;
import br.edu.fatecpg.revisao.model.Voo;
import br.edu.fatecpg.revisao.view.AeroportoView;

public class MainAeroporto {
    public static void main(String[] args) {
        Aeroporto aeroporto = new Aeroporto();
        AeroportoView view = new AeroportoView();

        Voo v1 = new Voo("AB1234", "São Paulo", "Recife", 5, 650.00);
        Voo v2 = new Voo("CD5678", "Rio de Janeiro", "Curitiba", 3, 420.00);

        aeroporto.adicionarVoo(v1);
        aeroporto.adicionarVoo(v2);

        view.exibirVoos(aeroporto.getVoos());

        // Teste de 2+ métodos: verificarDisponibilidade + realizarReserva + realizarPagamento + imprimirPassagem
        if (v1.verificarDisponibilidade(2) && v1.realizarReserva(2)) {
            double total = v1.realizarPagamento("idaEVolta", true);
            view.exibirResumoPagamento(v1.getNumeroVoo(), total);
            view.exibirPassagem(v1.imprimirPassagem());
        }

        if (v2.realizarReserva(1)) {
            double total = v2.realizarPagamento("ida", false);
            view.exibirResumoPagamento(v2.getNumeroVoo(), total);
            view.exibirPassagem(v2.imprimirPassagem());
        }

        view.exibirVoos(aeroporto.getVoos()); // mostra assentos restantes
    }
}