package aplicacao.assinantes.adiciona;

import dominio.entidades.assinante.Assinante;

import java.util.List;

public class AdicionaConcreto implements Adiciona {
    private List<Assinante> assinantes;

    public AdicionaConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public void adicionar(Assinante assinante) {
        assinantes.add(assinante);
    }
}
