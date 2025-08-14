package br.edu.fatecpg.revisao.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(Pedido p) { pedidos.add(p); }
    public boolean removerPedido(int numero) { return pedidos.removeIf(p -> p.getNumero() == numero); }

    public Pedido buscarPedido(int numero) {
        for (Pedido p : pedidos) if (p.getNumero() == numero) return p;
        return null;
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }
}