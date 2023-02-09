public class Endereco {
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public String getCep() {
        return cep;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getPais() {
        return pais;
    }
}
