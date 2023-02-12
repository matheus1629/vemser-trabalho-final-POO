public class Pagamento {
    private Integer quantidadeDeParcelas;
    private final Double IGPM = 3.79;
    private Double jurosVenda;
    private Double valorTotal;
    private Double entrada;


    public Integer getQuantidadeDeParcelas() {
        return quantidadeDeParcelas;
    }

    public void setQuantidadeDeParcelas(Integer quantidadeDeParcelas) {
        this.quantidadeDeParcelas = quantidadeDeParcelas;
    }

    public Double getIGPM() {
        return IGPM;
    }

    public Double getJurosVenda() {
        return jurosVenda;
    }

    public void setJurosVenda(Double jurosVenda) {
        this.jurosVenda = jurosVenda;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Double getEntrada() {
        return entrada;
    }
}
