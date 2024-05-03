package com.dto.biblioteca.domain.enums;

/* Classe enum é um tipo no qual declaramos um conjunto de valores constantes pré-definidos */
public enum Status {

    ATIVO(0, "ATIVO"), INATIVO(1, "INATIVO");

    private Integer codigo;
    private String descricao;

    private Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEdum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Status x : Status.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }
}
