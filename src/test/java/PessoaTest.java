import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class PessoaTest {

    private Pessoa pessoa;

    @Before
    public void beforeClass() throws Exception {
        String nome = "Brian";
        Integer idade = 24;
        pessoa = new Pessoa (nome, idade);
    }

    @Test
    public void deveSerPossivelInstanciarAClassePessoa() throws Exception {
        String nomeEsperado = "Brian";
        Integer idadeEsperada = 24;

        Pessoa pessoa = new Pessoa(nomeEsperado, idadeEsperada);

        Assertions.assertThat(pessoa.getNome()).isEqualTo(nomeEsperado);
        Assertions.assertThat(pessoa.getIdade()).isEqualTo(idadeEsperada);
    }

    @Test
    public void deveAtualizarAIdadeDaPessoa() throws Exception {
        Integer idadeEsperada = 25;

        pessoa.atualizarIdade(idadeEsperada);

        Assertions.assertThat(pessoa.getIdade()).isEqualTo(idadeEsperada);
    }

    @Test
    public void deveAtualizarONomeaPessoa() throws Exception {
        String nomeEsperado = "Diego";

        pessoa.atualizarNome(nomeEsperado);

        Assertions.assertThat(pessoa.getNome()).isEqualTo(nomeEsperado);
    }

    @Test
    public void naoDeveInstanciarUmaPessoaSeONomeForNulo() {
        String mensagemDeErroEsperada = "não foi possível criar a pessoa, porque o nome eh nulo";
        String nome = null;
        Integer idade = 20;

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Pessoa(nome, idade));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemDeErroEsperada);
    }

    @Test
    public void naoDeveSerPossivelCriarUmaPessoaComIdadeNula() {
        String mensagemEsperada = "Não foi possível criar a pessoa porque a idade é nula.";
        String nome = "Brian";
        Integer idade = null;

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Pessoa(nome, idade));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveRetornarONumeroAlteradoDoObjetoTestandoOMock() {
        int numeroParaRetornarEsperado = 2;
        int numeroDaClasseTestando = 1;
        TestandoOMock testandoOMock = new TestandoOMock(numeroDaClasseTestando);

        testandoOMock.trocarONumeroQuantoTiverMock(numeroParaRetornarEsperado);

        Assertions.assertThat(testandoOMock.getNumeroDaClasseTestando()).isEqualTo(numeroParaRetornarEsperado);
    }

    @Test
    public void deveRetornarONumeroMockadoDoObjetoTestoOMock() {
        int numeroInstanciado = 1;
        int numeroParaRetornar = 2;
        TestandoOMock testandoOMock = Mockito.mock(TestandoOMock.class);
        Mockito.when(testandoOMock.trocarONumeroQuantoTiverMock(numeroParaRetornar)).thenReturn(numeroInstanciado);

        int numeroRetornadoDepoisDeAplicadoOMock = testandoOMock.trocarONumeroQuantoTiverMock(50);

        Assertions.assertThat(numeroRetornadoDepoisDeAplicadoOMock).isEqualTo(numeroInstanciado);
    }
}