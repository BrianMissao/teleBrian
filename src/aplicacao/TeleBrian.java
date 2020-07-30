package aplicacao;

import dominio.CalculaRendaTotal;
import dominio.entidades.Assinante;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeNomeInvalido;

import java.math.BigDecimal;
import java.util.Scanner;

public class TeleBrian {
    private static GerenciadorDeAssinantes gerenciadorDeAssinantes = new GerenciadorDeAssinantes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ExcecaoDeNomeInvalido{
        cadastrarAssinante();
        cadastrarAssinante();
        cadastrarAssinante();
        exibirRelatorio();
    }

    private static void cadastrarAssinante() throws ExcecaoDeNomeInvalido {
        String nomeDoAssinante = obterDados("Informe o nome do assinante:");
        String nomeDoPlano = obterDados("Qual o plano este assinante aderiu?");
        BigDecimal valorDoPlano = new BigDecimal(obterDados("Qual o valor do plano?"));
        gerenciadorDeAssinantes.adicionarAssinante(new Assinante(nomeDoAssinante, new Plano(nomeDoPlano, valorDoPlano)));
    }

    private static void exibirRelatorio() {
        gerenciadorDeAssinantes.exibirAssinantes();
        System.out.println("Renda total da operadora: "+ CalculaRendaTotal.calcular(gerenciadorDeAssinantes.getAssinantes())+"R$");
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }
}
