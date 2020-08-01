package dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDeArgumentoInvalido extends Exception{
    private long serialVersionUid = 1l;
    private String mensagem;
    public ExcecaoDeArgumentoInvalido(String mensagem) {
        super(mensagem);
    }
}
