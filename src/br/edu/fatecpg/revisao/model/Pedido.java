package br.edu.fatecpg.revisao.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private List<ItemPedido> items = new ArrayList<>();
    private Double taxaEntrega;        // pode ser nula => sem entrega
    private Integer mesaReservada;     // null = nenhuma mesa reservada

    public Pedido(int numero) {
        this.numero = numero;
    }

    public int getNumero() { return numero; }
    public List<ItemPedido> getItems() { return new ArrayList<>(items); }
    public Integer getMesaReservada() { return mesaReservada; }

    public void definirTaxaEntrega(double taxaEntrega) {
        if (taxaEntrega < 0) throw new IllegalArgumentException("Taxa inválida");
        this.taxaEntrega = taxaEntrega;
    }

    public boolean reservarMesa(int numeroMesa) {
        if (numeroMesa <= 0) return false;
        if (this.mesaReservada != null) return false; // já reservada
        this.mesaReservada = numeroMesa;
        return true;
    }

    public void adicionarItem(ItemPedido item) {
        // se já existir o mesmo prato, soma quantidades para facilitar
        for (int i = 0; i < items.size(); i++) {
            ItemPedido it = items.get(i);
            if (it.getNomeDoPrato().equalsIgnoreCase(item.getNomeDoPrato())) {
                int novaQtd = it.getQuantidade() + item.getQuantidade();
                items.set(i, new ItemPedido(it.getNomeDoPrato(), novaQtd, it.getPrecoUnitario()));
                return;
            }
        }
        items.add(item);
    }

    public boolean removerItem(ItemPedido item) {
        return items.remove(item);
    }

    public double calcularTotalPedido() {
        double total = 0.0;
        for (ItemPedido it : items) total += it.getSubtotal();
        if (taxaEntrega != null) total += taxaEntrega;
        return total;
    }

    @Override
    public String toString() {
        return "Pedido #" + numero +
                (mesaReservada != null ? " (Mesa " + mesaReservada + ")" : "") +
                " - Itens: " + items.size() +
                String.format(" - Total: R$ %.2f", calcularTotalPedido());
    }
}