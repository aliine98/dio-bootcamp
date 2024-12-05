package br.com.aline;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class Conteudo {
    protected static final double XP_BASE = 5.0;
    private static int contador = 0;
    protected int id;
    protected String titulo;
    protected String descricao;

    protected Conteudo() {
        contador++;
        this.id = contador;
    }

    public Conteudo titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Conteudo descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Conteudo build() {
        return this;
    }

    public abstract double calcularXp();
}
