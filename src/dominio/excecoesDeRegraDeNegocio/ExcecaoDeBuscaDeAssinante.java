package dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDeBuscaDeAssinante extends Exception{
    private long serialVersionUid = 1l;
    private String mensagem;

    public ExcecaoDeBuscaDeAssinante(String mensagem) {
        super(mensagem);
    }
}
