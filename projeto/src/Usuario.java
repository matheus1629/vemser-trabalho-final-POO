public abstract class Usuario {
    private String nome;
    private String identificacao;

    Contato contato = new Contato();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getIdentificacao() {
        return identificacao;
    }
}
