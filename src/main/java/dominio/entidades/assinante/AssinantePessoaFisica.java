package dominio.entidades.assinante;

import dominio.Validador;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

public class AssinantePessoaFisica extends Assinante {
    private String cpf;

    public AssinantePessoaFisica(String nome, String cpf, Plano plano) throws ExcecaoDeArgumentoInvalido {
        super(nome, plano);
        new Validador().validarString(cpf);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "*"+getNome()+"\nCPF: "+cpf+"\nPlano contratado: "+obterNomeDoPlano()+"\nValor do plano contratado: "+obterValorDoPlano();
    }

    public String getCpf() {
        return cpf;
    }
}
