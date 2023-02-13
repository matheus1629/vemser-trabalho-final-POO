public class Imovel {
    private Endereco endereco;
    private boolean disponibilidade;
    private int quantidadeDeComodos;
    private int codigo;
    private Double valor;
    private String status;

    public Imovel() {
    }

    ;

    public Imovel(Endereco endereco, int codigo, Double valor, String status) {
        this.endereco = endereco;
        this.disponibilidade = true;
        this.codigo = codigo;
        this.valor = valor;
        this.status = status.toLowerCase();
    }

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
