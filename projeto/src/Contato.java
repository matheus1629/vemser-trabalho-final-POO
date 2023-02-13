public class Contato {
    private String telefone;
    private String email;

    public Contato(){}
    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
