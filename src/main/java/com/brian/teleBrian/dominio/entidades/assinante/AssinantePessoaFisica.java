package com.brian.teleBrian.dominio.entidades.assinante;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.brian.teleBrian.dominio.ValidadorDeCamposObrigatorios;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

@Entity
@DiscriminatorValue("ASSINANTE_PESSOA_FISICA")
public class AssinantePessoaFisica extends Assinante {

    @Column
    private String cpf;

    public AssinantePessoaFisica() {
        super();
    }

    public AssinantePessoaFisica(String nome, String cpf, Plano plano) throws ExcecaoDeArgumentoInvalido {
        super(nome, plano);
        validarCamposObrigatorios(cpf);
        this.cpf = cpf;
    }

    private void validarCamposObrigatorios(String campoAValidar) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(campoAValidar).validar();
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
