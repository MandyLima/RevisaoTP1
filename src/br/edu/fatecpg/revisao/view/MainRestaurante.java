package br.edu.fatecpg.revisao.view;

import br.edu.fatecpg.revisao.model.ItemPedido;
import br.edu.fatecpg.revisao.model.Pedido;
import br.edu.fatecpg.revisao.model.Restaurante;
import br.edu.fatecpg.revisao.view.RestauranteView;

public class MainRestaurante {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        RestauranteView view = new RestauranteView();

        Pedido p1 = new Pedido(101);
        p1.adicionarItem(new ItemPedido("Hamburguer", 2, 24.90));
        p1.adicionarItem(new ItemPedido("Refrigerante", 2, 7.50));
        p1.definirTaxaEntrega(6.00);
        p1.reservarMesa(12);

        Pedido p2 = new Pedido(102);
        p2.adicionarItem(new ItemPedido("Pizza", 1, 58.00));
        p2.adicionarItem(new ItemPedido("Suco", 3, 6.00));

        restaurante.adicionarPedido(p1);
        restaurante.adicionarPedido(p2);

        // Teste de 2+ métodos: adicionar/remover/calcular/exibir
        view.exibirPedidoDetalhado(p1);             // calcularTotalPedido + reservarMesa
        p2.removerItem(new ItemPedido("Suco", 1, 6.00));
        view.exibirPedidoDetalhado(p2);             // removerItem + calcularTotalPedido
        view.exibirTodosPedidos(restaurante.getPedidos()); // exibir todos
    }
}