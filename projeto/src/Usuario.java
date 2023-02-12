public abstract class Usuario {
    private String nome;
    private String cpf;

    private Contato contato = new Contato();
    private String loginUsuario;
    private String senha;
    private String tipo;

    public Usuario(String nome, String cpf, Contato contato, String loginUsuario, String senha, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.loginUsuario = loginUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
