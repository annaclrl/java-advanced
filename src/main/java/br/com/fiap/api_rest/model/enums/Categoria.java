package br.com.fiap.api_rest.model.enums;

public enum Categoria {
    ELETRONICO("Eletrônico"),
    LIVROS("Livros"),
    OUTROS("Outro");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
