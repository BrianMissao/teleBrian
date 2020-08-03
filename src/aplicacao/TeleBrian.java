package aplicacao;

import aplicacao.operacoesComAssinantes.AdicionaAssinante;
import aplicacao.operacoesComAssinantes.ExibeInformacoesDeTodosOsAssinantes;
import aplicacao.operacoesComAssinantes.BuscaAssinante;
import aplicacao.operacoesComAssinantes.RemoveAssinante;
import dominio.CalculaFaturamento;
import dominio.entidades.Assinante;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeleBrian {
    private static List<Assinante> assinantes =  new ArrayList<>();
    private static AdicionaAssinante adicionaAssinante = new AdicionaAssinante(assinantes);
    private static ExibeInformacoesDeTodosOsAssinantes exibeInformacoesDeTodosOsAssinantes = new ExibeInformacoesDeTodosOsAssinantes(assinantes);
    private static RemoveAssinante removeAssinante = new RemoveAssinante(assinantes);
    private static BuscaAssinante procuraPorUmAssinante = new BuscaAssinante(assinantes);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ExcecaoDeArgumentoInvalido {
        cadastrarAssinante();
        cadastrarAssinante();
        exibirRelatorio();
    }

    private static void cadastrarAssinante() throws ExcecaoDeArgumentoInvalido {
        String nomeDoAssinante = obterDados("Informe o nome do assinante:");
        String nomeDoPlano = obterDados("Qual o plano este assinante aderiu?");
        BigDecimal valorDoPlano = new BigDecimal(obterDados("Qual o valor do plano?"));
        Assinante assinanteAAdicionar = new Assinante(nomeDoAssinante, new Plano(nomeDoPlano, valorDoPlano));
        if (adicionaAssinante.adicionar(assinanteAAdicionar)){
            System.out.println("Assinante adicionado com sucesso!");
            return;
        }
        System.out.println("Houve um erro ao tentar adicionar o assinante de nome"+nomeDoAssinante+".\nVerifique os dados e tente novamente.");
    }

    private static void exibirRelatorio() {
        exibeInformacoesDeTodosOsAssinantes.exibir();
        System.out.println("Faturamento da operadora: "+ CalculaFaturamento.calcular(assinantes)+"R$");
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }
}
