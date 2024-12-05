package br.com.aline;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Desenvolvedor {
    private static int contador;
    private int id;
    private String nome;
    private Map<Conteudo, Status> atividades = new HashMap<>();
    private Map<Bootcamp, Status> bootcamps = new HashMap<>();

    public Desenvolvedor(String nome) {
        this.nome = nome;
        contador++;
        this.id = contador;
    }

    public void inscreverNoBootcamp(Bootcamp bootcamp) {
        bootcamp.adicionaDesenvolvedor(this);
        for (Conteudo conteudo : bootcamp.getConteudos()) {
            this.atividades.putIfAbsent(conteudo, Status.CURSANDO);
        }
        this.bootcamps.put(bootcamp, Status.CURSANDO);
    }

    public void cancelarInscricaoNoBootcamp(Bootcamp bootcamp) {
        bootcamp.removeDesenvolvedor(this);
        for (Conteudo conteudo : bootcamp.getConteudos()) {
            this.atividades.remove(conteudo);
        }
        this.bootcamps.remove(bootcamp);
    }

    public void progrideNoBootcamp(Bootcamp bootcamp) {
        Conteudo atividade = null;
        for(Map.Entry<Conteudo, Status> entry : this.atividades.entrySet()) {
            if(isAtividadeNaoConcluida(bootcamp, entry)) {
                atividade = entry.getKey();
                break;
            } else {
                concluiBootcamp(bootcamp);
            }
        }

        if (atividade != null) {
            concluiAtividade(atividade);
        }
    }

    private void concluiAtividade(Conteudo atividade) {
        this.atividades.replace(atividade, Status.CONCLUIDO);
    }

    private void concluiBootcamp(Bootcamp bootcamp) {
        this.bootcamps.replace(bootcamp, Status.CONCLUIDO);
    }

    private static boolean isAtividadeNaoConcluida(Bootcamp bootcamp, Map.Entry<Conteudo, Status> entry) {
        return entry.getValue().equals(Status.CURSANDO) && bootcamp.getConteudos().contains(entry.getKey());
    }

    public double calcularTotalXp() {
        return this.atividades.entrySet().stream()
                .filter(entry -> entry.getValue().equals(Status.CONCLUIDO))
                .mapToDouble(entry -> entry.getKey().calcularXp())
                .reduce(0, Double::sum);
    }

    @Override
    public String toString() {
        return "Desenvolvedor{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
