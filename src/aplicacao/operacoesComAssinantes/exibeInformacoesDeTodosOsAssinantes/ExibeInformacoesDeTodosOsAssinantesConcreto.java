package aplicacao.operacoesComAssinantes.exibeInformacoesDeTodosOsAssinantes;

import dominio.entidades.Assinante;

import java.util.List;

public class ExibeInformacoesDeTodosOsAssinantesConcreto implements ExibeInformacoesDeTodosOsAssinantes {
    private List<Assinante> assinantes;

    public ExibeInformacoesDeTodosOsAssinantesConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public void exibir() {
        System.out.println("*Assinantes");
        assinantes.forEach(System.out::println);
    }

}
