package dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDeRemocaoDeAssinante extends Exception {
    private long serialVersionUID = 1l;
    private String mensagem;

    public ExcecaoDeRemocaoDeAssinante(String mensagem) {
        super(mensagem);
    }
}
