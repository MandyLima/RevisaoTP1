package br.edu.fatecpg.revisao.model;

public class Voo {
    private String numeroVoo;
    private String origem;
    private String destino;
    private int assentosDisponiveis;
    private double precoBasePorAssento;

    // estado de compra atual (simples, por voo)
    private int assentosReservados = 0;
    private String tipoViagemEfetuada = null; // "ida" ou "idaEVolta"
    private boolean incluiuPontosTuristicos = false;

    public Voo(String numeroVoo, String origem, String destino, int assentosDisponiveis, double precoBasePorAssento) {
        if (assentosDisponiveis < 0) throw new IllegalArgumentException("Assentos inválidos");
        if (precoBasePorAssento < 0) throw new IllegalArgumentException("Preço inválido");
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.assentosDisponiveis = assentosDisponiveis;
        this.precoBasePorAssento = precoBasePorAssento;
    }

    public String getNumeroVoo() { return numeroVoo; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public int getAssentosDisponiveis() { return assentosDisponiveis; }
    public int getAssentosReservados() { return assentosReservados; }

    public boolean verificarDisponibilidade(int quantidadeAssentos) {
        return quantidadeAssentos > 0 && quantidadeAssentos <= assentosDisponiveis;
    }

    public boolean realizarReserva(int quantidadeAssentos) {
        if (!verificarDisponibilidade(quantidadeAssentos)) return false;
        assentosDisponiveis -= quantidadeAssentos;
        assentosReservados += quantidadeAssentos;
        return true;
    }

    /**
     * tipoViagem: "ida" | "idaEVolta"
     * pontosTuristicos: adiciona taxa de 15% no total
     */
    public double realizarPagamento(String tipoViagem, boolean pontosTuristicos) {
        if (assentosReservados == 0) throw new IllegalStateException("Nenhuma reserva efetuada");
        if (!"ida".equalsIgnoreCase(tipoViagem) && !"idaEVolta".equalsIgnoreCase(tipoViagem)) {
            throw new IllegalArgumentException("tipoViagem deve ser 'ida' ou 'idaEVolta'");
        }

        double multiplicador = "idaEVolta".equalsIgnoreCase(tipoViagem) ? 2.0 : 1.0;
        double total = assentosReservados * precoBasePorAssento * multiplicador;

        if (pontosTuristicos) total *= 1.15; // taxa adicional

        // registra venda simples
        this.tipoViagemEfetuada = tipoViagem;
        this.incluiuPontosTuristicos = pontosTuristicos;

        return total;
    }

    public String imprimirPassagem() {
        if (assentosReservados == 0 || tipoViagemEfetuada == null) {
            return "Nenhuma passagem paga para este voo.";
        }
        String tipo = "ida".equalsIgnoreCase(tipoViagemEfetuada) ? "Somente ida" : "Ida e volta";
        String pontos = incluiuPontosTuristicos ? "Sim" : "Não";
        return String.format(
                """
                === DETALHES DA PASSAGEM ===
                Voo: %s  (%s -> %s)
                Assentos: %d
                Tipo de viagem: %s
                Pontos turísticos: %s
                """,
                numeroVoo, origem, destino, assentosReservados, tipo, pontos
        );
    }

    @Override
    public String toString() {
        return String.format("Voo %s %s->%s | Assentos disp.: %d | Preço base: R$ %.2f",
                numeroVoo, origem, destino, assentosDisponiveis, precoBasePorAssento);
    }
}