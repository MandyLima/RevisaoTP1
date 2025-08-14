package br.edu.fatecpg.revisao.view;

import br.edu.fatecpg.revisao.model.ItemPedido;
import br.edu.fatecpg.revisao.model.Pedido;

import java.util.List;

public class RestauranteView {
    public void exibirPedidoDetalhado(Pedido p) {
        System.out.println("=== Detalhes do Pedido #" + p.getNumero() + " ===");
        for (ItemPedido it : p.getItems()) System.out.println(" - " + it);
        if (p.getMesaReservada() != null) System.out.println("Mesa reservada: " + p.getMesaReservada());
        System.out.printf("TOTAL: R$ %.2f%n", p.calcularTotalPedido());
        System.out.println();
    }

    public void exibirTodosPedidos(List<Pedido> lista) {
        System.out.println("=== Pedidos Registrados ===");
        for (Pedido p : lista) System.out.println(p);
        System.out.println();
    }
}