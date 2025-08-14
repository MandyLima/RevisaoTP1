package br.edu.fatecpg.revisao.model;

import java.util.Objects;

public class ItemPedido {
    private String nomeDoPrato;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String nomeDoPrato, int quantidade, double precoUnitario) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser > 0");
        if (precoUnitario < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
        this.nomeDoPrato = nomeDoPrato;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNomeDoPrato() { return nomeDoPrato; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }

    public double getSubtotal() {
        return quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return String.format("%s x%d (R$ %.2f) = R$ %.2f",
                nomeDoPrato, quantidade, precoUnitario, getSubtotal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(nomeDoPrato, that.nomeDoPrato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoPrato);
    }
}