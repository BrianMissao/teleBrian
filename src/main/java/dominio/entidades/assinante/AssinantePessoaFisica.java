package dominio.entidades.assinante;

import dominio.ValidadorDeCamposObrigatorios;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

public class AssinantePessoaFisica extends Assinante {
    private String cpf;

    public AssinantePessoaFisica(String nome, String cpf, Plano plano) throws ExcecaoDeArgumentoInvalido {
        super(nome, plano);
        validarCamposObrigatorios(cpf);
        this.cpf = cpf;
    }

    private void validarCamposObrigatorios(String campoAValidar) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(campoAValidar);
    }

    @Override
    public String toString() {
        return "*"+getNome()+"\nCPF: "+cpf+"\nPlano contratado: "+obterNomeDoPlano()+"\nValor do plano contratado: "+obterValorDoPlano();
    }

    public String getCpf() {
        return cpf;
    }

    public void atualizarCpf(String cpfAtualizado) throws ExcecaoDeArgumentoInvalido {
        validarCamposObrigatorios(cpfAtualizado);
        this.cpf = cpfAtualizado;
    }
}
