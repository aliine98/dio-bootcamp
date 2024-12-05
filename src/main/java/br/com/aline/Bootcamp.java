package br.com.aline;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Bootcamp {
    private static int contador;
    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Set<Desenvolvedor> desenvolvedores = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    @Builder
    public Bootcamp(String nome, String descricao, LocalDate dataInicio, LocalDate dataFinal) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        contador++;
        this.id = contador;
    }

    public void adicionaDesenvolvedor(Desenvolvedor dev) {
        this.desenvolvedores.add(dev);
    }

    public void removeDesenvolvedor(Desenvolvedor dev) {
        this.desenvolvedores.remove(dev);
    }

    public void adicionaConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
    }

    public void adicionaConteudos(Set<Conteudo> conteudos) {
        this.conteudos.addAll(conteudos);
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                '}';
    }
}
