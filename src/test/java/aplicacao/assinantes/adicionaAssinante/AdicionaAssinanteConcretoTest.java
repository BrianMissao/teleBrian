package aplicacao.assinantes.adicionaAssinante;

import dominio.entidades.assinante.Assinante;
import dominio.builders.AssinantePessoaFisicaBuilder;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AdicionaAssinanteConcretoTest {
    @Test
    public void deveAdicionarUmAssinanteNaLista() throws ExcecaoDeArgumentoInvalido {
        List<Assinante> assinantes = new ArrayList<>();
        Assinante assinanteDoTipoPessoaFisica = new AssinantePessoaFisicaBuilder().criar();
        AdicionaAssinante adicionaAssinante = new AdicionaAssinanteConcreto(assinantes);

        adicionaAssinante.adicionar(assinanteDoTipoPessoaFisica);

        Assertions.assertThat(assinantes).contains(assinanteDoTipoPessoaFisica);
    }

}