public class Imovel {
    private Endereco endereco;
    private int quantidadeDeComodos;

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
}
