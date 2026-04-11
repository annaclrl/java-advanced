package br.com.fiap.api_rest.model.enums;

public enum StatusPedido {
    PAGA("Pago"),
    CANCELADO("Cancelado");

    private String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
