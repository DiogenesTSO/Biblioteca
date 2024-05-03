package com.dto.biblioteca.domain.enums;

/* Classe enum é um tipo no qual declaramos um conjunto de valores constantes pré-definidos */
public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"), ALUNO(1, "ROLE_ALUNO");

    private Integer codigo;
    private String descricao;

    private Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEdum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido");
    }
}
