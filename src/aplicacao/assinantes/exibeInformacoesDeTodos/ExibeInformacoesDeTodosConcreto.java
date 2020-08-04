package aplicacao.assinantes.exibeInformacoesDeTodos;

import dominio.entidades.assinante.Assinante;

import java.util.List;

public class ExibeInformacoesDeTodosConcreto implements ExibeInformacoesDeTodos {
    private List<Assinante> assinantes;

    public ExibeInformacoesDeTodosConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public void exibir() {
        System.out.println("*Assinantes");
        assinantes.forEach(System.out::println);
    }

}
