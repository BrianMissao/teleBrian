package dominio.entidades.assinante;

import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

public class AssinantePessoaFisica extends Assinante{
    private String cpf;

    public AssinantePessoaFisica(String nome, String cpf, Plano plano) throws ExcecaoDeArgumentoInvalido {
        super(nome, plano);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "*"+getNome()+"\nCPF: "+getCpf()+"\nPlano contratado: "+obterNomeDoPlano()+"\nValor do plano contratado: "+obterValorDoPlano()+"R$";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
