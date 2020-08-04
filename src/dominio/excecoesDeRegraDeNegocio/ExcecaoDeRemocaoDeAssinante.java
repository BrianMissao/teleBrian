package dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDeRemocaoDeAssinante extends Exception{
    private long serialVersionUid = 1l;
    private String mensagem;
    public ExcecaoDeRemocaoDeAssinante(String mensagem) {
        super(mensagem);
    }
}
