public class Imovel {
    private Endereco endereco;
    private boolean disponibilidade;
    private int quantidadeDeComodos;
    private int area;
    private int codigo;
    private Double valor;
    private String status;


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setQuantidadeDeComodos(int quantidadeDeComodos) {
        this.quantidadeDeComodos = quantidadeDeComodos;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public int getQuantidadeDeComodos() {
        return quantidadeDeComodos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
