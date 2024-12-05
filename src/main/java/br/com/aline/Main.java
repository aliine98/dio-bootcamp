package br.com.aline;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bootcamp b1 = Bootcamp.builder().nome("Bootcamp Java").dataInicio(LocalDate.now()).build();

        Conteudo c1 = new Curso(10).titulo("Programação orientada a objetos").descricao("Descrição teste").build();
        Conteudo c2 = new Mentoria(LocalDate.of(2024,12,5)).titulo("Mercado de trabalho Java").descricao("descricao teste").build();

        b1.adicionaConteudo(c1);
        b1.adicionaConteudo(c2);

        Desenvolvedor dev = new Desenvolvedor("Aline");
        dev.inscreverNoBootcamp(b1);
        System.out.println(b1);
        System.out.println(dev.getAtividades());
        System.out.println(dev.getBootcamps());
        System.out.println(dev.calcularTotalXp());
        dev.progrideNoBootcamp(b1);
        System.out.println(dev.calcularTotalXp());
        dev.progrideNoBootcamp(b1);
        System.out.println(dev.calcularTotalXp());
        System.out.println(dev.getBootcamps());
    }
}