package aplicacao;

import dominio.entidades.Assinante;
import dominio.entidades.Plano;

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

    public void exibirInformacoesDeTodosOsAssinantes() {
        System.out.println("*Assinantes");
        assinantes.forEach(System.out::println);
    }

    public void exibirInformacoesDeUmAssinanteEspecifico(String nomeDoAssinanteAExibir) {
        Assinante assinante = buscarAssinante(nomeDoAssinanteAExibir);
        String mensagemAoUsuario = assinante != null ? assinante.toString() : "O assinante " + nomeDoAssinanteAExibir + " não está cadastrado.";
        System.out.println(mensagemAoUsuario);
    }

    public void removerAssinante(String nomeDoAssinanteARemover) {
        if (assinantes.removeIf(assinante -> assinante.getNome().equals(nomeDoAssinanteARemover))) {
            System.out.println("O assinante " + nomeDoAssinanteARemover+" foi removido com sucesso.");
            return;
        }
        System.out.println("O assinante " + nomeDoAssinanteARemover + " não está cadastrado, portanto não pode ser removido.");
    }

    public Assinante buscarAssinante(String nomeDoAssinanteABuscar) {
        for (Assinante assinante : assinantes) {
            if (assinante.getNome().equals(nomeDoAssinanteABuscar)) {
                return assinante;
            }
        }
        return null;
    }

    public List<Assinante> getAssinantes() {
        return Collections.unmodifiableList(assinantes);
    }
}
