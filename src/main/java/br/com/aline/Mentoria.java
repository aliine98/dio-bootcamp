package br.com.aline;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Mentoria extends Conteudo {
    private LocalDate data;

    public Mentoria(LocalDate data) {
        this.data = data;
    }

    @Override
    public double calcularXp() {
        return 40.0;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + titulo + '\'' +
                ", data=" + data +
                '}';
    }
}
