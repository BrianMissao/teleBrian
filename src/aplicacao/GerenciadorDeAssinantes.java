package aplicacao;

import dominio.entidades.Assinante;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorDeAssinantes {
    private List<Assinante> assinantes = new ArrayList<>();

    public void adicionarAssinante(Assinante assinante) {
        assinantes.add(assinante);
    }

    public void exibirAssinantes() {
        System.out.println("*Assinantes");
        assinantes.forEach(assinante -> System.out.println(assinante.getNome()+", contratou o plano "+assinante.getPlano().getNome()+", no valor de "+assinante.getPlano().getValor()+"R$"));
    }
    public List<Assinante> getAssinantes() {
        return Collections.unmodifiableList(assinantes);
    }
}
