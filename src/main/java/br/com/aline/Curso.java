package br.com.aline;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso extends Conteudo{
    private int cargaHoraria;

    public Curso(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return Conteudo.XP_BASE * cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + titulo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
