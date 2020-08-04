package dominio.entidades.assinante;

import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

public class AssinantePessoaJuridica extends Assinante {
    private String cnpj;

    public AssinantePessoaJuridica(String nome, String cnpj, Plano plano) throws ExcecaoDeArgumentoInvalido {
        super(nome, plano);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "*"+getNome()+"\nCNPJ: "+getCnpj()+"\nPlano contratado: "+obterNomeDoPlano()+"\nValor do plano contratado: "+obterValorDoPlano();
    }
}
