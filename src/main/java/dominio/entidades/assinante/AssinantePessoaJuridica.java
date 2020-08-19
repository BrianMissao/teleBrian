package dominio.entidades.assinante;

import dominio.Validador;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AssinantePessoaJuridica extends Assinante {
    private String cnpj;

    public AssinantePessoaJuridica(String nome, String cnpj, Plano plano) throws ExcecaoDeArgumentoInvalido {
        super(nome, plano);
        new Validador().validarString(cnpj);
        this.cnpj = cnpj;
    }

    @Override
    public BigDecimal obterValorDoPlano() {
        BigDecimal valorDoDesconto = super.obterValorDoPlano().multiply(new BigDecimal("0.25"));
        return super.obterValorDoPlano().subtract(valorDoDesconto).setScale(2, RoundingMode.HALF_EVEN);
    }
    public String getCnpj() {
        return cnpj;
    }
}
