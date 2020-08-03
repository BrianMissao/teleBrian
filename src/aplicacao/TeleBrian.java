package aplicacao;

import aplicacao.operacoesComAssinantes.adicionaAssinante.AdicionaAssinante;
import aplicacao.operacoesComAssinantes.adicionaAssinante.AdicionaAssinanteConcreto;
import aplicacao.operacoesComAssinantes.exibeInformacoesDeTodosOsAssinantes.ExibeInformacoesDeTodosOsAssinantes;
import aplicacao.operacoesComAssinantes.exibeInformacoesDeTodosOsAssinantes.ExibeInformacoesDeTodosOsAssinantesConcreto;
import aplicacao.operacoesComAssinantes.buscaAssinante.BuscaAssinante;
import aplicacao.operacoesComAssinantes.buscaAssinante.BuscaAssinanteConcreto;
import aplicacao.operacoesComAssinantes.removeAssinante.RemoveAssinante;
import aplicacao.operacoesComAssinantes.removeAssinante.RemoveAssinanteConcreto;
import dominio.CalculaFaturamento;
import dominio.entidades.Assinante;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeleBrian {
    private static List<Assinante> assinantes = new ArrayList<>();
    private static AdicionaAssinante adicionaAssinante = new AdicionaAssinanteConcreto(assinantes);
    private static ExibeInformacoesDeTodosOsAssinantes exibeInformacoesDeTodosOsAssinantes = new ExibeInformacoesDeTodosOsAssinantesConcreto(assinantes);
    private static RemoveAssinante removeAssinante = new RemoveAssinanteConcreto(assinantes);
    private static BuscaAssinante buscaAssinante = new BuscaAssinanteConcreto(assinantes);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ExcecaoDeArgumentoInvalido {
        cadastrarAssinante();
        cadastrarAssinante();
        exibirRelatorio();
        String assinanteAExibirRelatorio = obterDados("Digite o assinante sobre o qual deseja exibir relatório:");
        exibirRelatorioSobreUmAssinanteEspecifico(assinanteAExibirRelatorio);
    }

    private static void cadastrarAssinante() throws ExcecaoDeArgumentoInvalido {
        String nomeDoAssinante = obterDados("Informe o nome do assinante:");
        String nomeDoPlano = obterDados("Qual o plano este assinante aderiu?");
        BigDecimal valorDoPlano = new BigDecimal(obterDados("Qual o valor do plano?"));
        Assinante assinanteAAdicionar = new Assinante(nomeDoAssinante, new Plano(nomeDoPlano, valorDoPlano));
        if (adicionaAssinante.adicionar(assinanteAAdicionar)) {
            System.out.println("Assinante adicionado com sucesso!");
            return;
        }
        System.out.println("Houve um erro ao tentar adicionar o assinante de nome" + nomeDoAssinante + ".\nVerifique os dados e tente novamente.");
    }

    private static void exibirRelatorio() {
        exibeInformacoesDeTodosOsAssinantes.exibir();
        System.out.println("Faturamento da operadora: " + CalculaFaturamento.calcular(assinantes) + "R$");
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }

    private static void exibirRelatorioSobreUmAssinanteEspecifico(String assinanteAExibirRelatorio) {
        try {
            String relatorioDoAssinante = buscaAssinante.buscar(assinanteAExibirRelatorio).toString();
            System.out.println(relatorioDoAssinante);
        } catch (ExcecaoDeBuscaDeAssinante excecaoDeBusca) {
            System.out.println("Erro: "+excecaoDeBusca.getMessage());
        }
    }
}
