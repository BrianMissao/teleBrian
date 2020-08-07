package aplicacao;

import aplicacao.assinantes.adiciona.Adiciona;
import aplicacao.assinantes.adiciona.AdicionaConcreto;
import aplicacao.assinantes.exibeInformacoesDeTodos.ExibeInformacoesDeTodos;
import aplicacao.assinantes.exibeInformacoesDeTodos.ExibeInformacoesDeTodosConcreto;
import aplicacao.assinantes.busca.Busca;
import aplicacao.assinantes.busca.BuscaConcreto;
import aplicacao.assinantes.remove.Remove;
import aplicacao.assinantes.remove.RemoveConcreto;
import dominio.calculos.CalculoDeFaturamento;
import dominio.calculos.CalculoDeGastos;
import dominio.calculos.Calculos;
import dominio.entidades.Funcionario;
import dominio.entidades.assinante.Assinante;
import dominio.entidades.Plano;
import dominio.entidades.assinante.AssinantePessoaFisica;
import dominio.entidades.assinante.AssinantePessoaJuridica;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeleBrian {
    private static List<Assinante> assinantes = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Adiciona adiciona = new AdicionaConcreto(assinantes);
    private static ExibeInformacoesDeTodos exibeInformacoesDeTodos = new ExibeInformacoesDeTodosConcreto(assinantes);
    private static Remove remove = new RemoveConcreto(assinantes);
    private static Busca busca = new BuscaConcreto(assinantes);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ExcecaoDeArgumentoInvalido {
        cadastrarAssinante();
        cadastrarAssinante();
        cadastrarFuncionario();
        exibirRelatorio();
    }

    private static void cadastrarAssinante() throws ExcecaoDeArgumentoInvalido {
        String tipoDeAssinanteACadastrar = obterDados("Pessoa física ou jurídica?");
        String nomeDoAssinante = obterDados("Informe o nome do assinante:");
        String nomeDoPlano = obterDados("Qual o plano este assinante aderiu?");
        BigDecimal valorDoPlano = new BigDecimal(obterDados("Qual o valor do plano?"));
        if (tipoDeAssinanteACadastrar.equals("fisica")) {
            cadastrarAssinantePessoaFisica(nomeDoAssinante, nomeDoPlano, valorDoPlano);
            return;
        }
        cadastrarAssinantePessoaJuridica(nomeDoAssinante, nomeDoPlano, valorDoPlano);
    }

    private static void cadastrarFuncionario() {
        String nomeDoFuncionario = obterDados("Informe o nome do funcionário:");
        Integer numeroDaMatriculaDoFuncionario = Integer.valueOf(obterDados("Informe o número da matrícula:"));
        BigDecimal salarioDoFuncionario = new BigDecimal(obterDados("Qual o salário deste funcionário?"));
        try {
            funcionarios.add(new Funcionario(nomeDoFuncionario, numeroDaMatriculaDoFuncionario, salarioDoFuncionario));
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (ExcecaoDeArgumentoInvalido excecaoDeArgumentoInvalido) {
            System.out.println("Erro: " + excecaoDeArgumentoInvalido.getMessage());
        }
    }

    private static void exibirRelatorio() {
        Calculos calculoDeFaturamento = new CalculoDeFaturamento(assinantes);
        Calculos calculoDeGastos = new CalculoDeGastos(funcionarios);
        BigDecimal balancoFinanceiro = new ObtemBalancoFinanceiro(calculoDeFaturamento, calculoDeGastos).obter();
        exibeInformacoesDeTodos.exibir();
        System.out.println("Faturamento da operadora: " + calculoDeFaturamento.calcular() + "R$");
        System.out.println("Gastos da operadora: "+calculoDeGastos.calcular()+"R$");
        System.out.println("Balanço financeiro: "+balancoFinanceiro+"R$");
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }

    private static void exibirRelatorioSobreUmAssinanteEspecifico(String assinanteAExibirRelatorio) {
        try {
            String relatorioDoAssinante = busca.buscar(assinanteAExibirRelatorio).toString();
            System.out.println(relatorioDoAssinante);
        } catch (ExcecaoDeBuscaDeAssinante excecaoDeBusca) {
            System.out.println("Erro: " + excecaoDeBusca.getMessage());
        }
    }

    private static void cadastrarAssinantePessoaFisica(String nomeDoAssinante, String nomeDoPlano, BigDecimal valorDoPlano) throws ExcecaoDeArgumentoInvalido {
        String cpfDoAssinante = obterDados("Informe o CPF do assinante:");
        Assinante assinanteAAdicionar = new AssinantePessoaFisica(nomeDoAssinante, cpfDoAssinante, new Plano(nomeDoPlano, valorDoPlano));
        adiciona.adicionar(assinanteAAdicionar);
        System.out.println("Assinante adicionado com sucesso!");
    }

    private static void cadastrarAssinantePessoaJuridica(String nomeDoAssinante, String nomeDoPlano, BigDecimal valorDoPlano) throws ExcecaoDeArgumentoInvalido {
        String cnpjDoAssinante = obterDados("Informe o CNPJ do assinante:");
        Assinante assinanteAAdicionar = new AssinantePessoaJuridica(nomeDoAssinante, cnpjDoAssinante, new Plano(nomeDoPlano, valorDoPlano));
        adiciona.adicionar(assinanteAAdicionar);
        System.out.println("Assinante adicionado com sucesso!");
    }
}
