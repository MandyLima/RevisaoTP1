package br.edu.fatecpg.revisao.model;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
    private List<Voo> voos = new ArrayList<>();

    public void adicionarVoo(Voo v) { voos.add(v); }
    public boolean removerVoo(String numeroVoo) {
        return voos.removeIf(v -> v.getNumeroVoo().equalsIgnoreCase(numeroVoo));
    }

    public Voo buscarVoo(String numeroVoo) {
        for (Voo v : voos) if (v.getNumeroVoo().equalsIgnoreCase(numeroVoo)) return v;
        return null;
    }

    public List<Voo> getVoos() { return new ArrayList<>(voos); }
}