package br.edu.fatecpg.revisao.view;

import br.edu.fatecpg.revisao.model.Voo;

import java.util.List;

public class AeroportoView {
    public void exibirVoos(List<Voo> voos) {
        System.out.println("=== Voos Disponíveis ===");
        for (Voo v : voos) System.out.println(v);
        System.out.println();
    }

    public void exibirResumoPagamento(String numeroVoo, double total) {
        System.out.printf("Pagamento do voo %s confirmado. Total: R$ %.2f%n%n", numeroVoo, total);
    }

    public void exibirPassagem(String detalhes) {
        System.out.println(detalhes);
        System.out.println();
    }
}