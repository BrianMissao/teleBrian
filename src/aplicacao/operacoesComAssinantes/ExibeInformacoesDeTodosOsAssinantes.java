package aplicacao.operacoesComAssinantes;

import dominio.entidades.Assinante;

import java.util.List;

public class ExibeInformacoesDeTodosOsAssinantes {
    private List<Assinante> assinantes;
    public ExibeInformacoesDeTodosOsAssinantes(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    public void exibir() {
        System.out.println("*Assinantes");
        assinantes.forEach(System.out::println);
    }

}
