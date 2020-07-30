package dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDeNomeInvalido extends Exception{
    private long serialVersionUid = 1l;
    private String mensagem;
    public ExcecaoDeNomeInvalido(String mensagem) {
        super(mensagem);
    }
}
