public class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa(String nome, Integer idade) throws Exception {
        validarNomeDaPessoa(nome);
        validarIdade(idade);
        this.nome = nome;
        this.idade = idade;
    }

    private void validarNomeDaPessoa(String nome) throws Exception {
        if (nome == null) {
            throw new Exception("não foi possível criar a pessoa, porque o nome eh nulo");
        }
    }

    private void validarIdade(Integer idade) throws Exception {
        if (idade == null) {
            throw new Exception("Não foi possível criar a pessoa porque a idade é nula.");
        }
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void atualizarIdade(Integer idade) {
        this.idade = idade;
    }

    public void atualizarNome(String nome) {
        this.nome = nome;
    }
}
