public class Pagamento {
    private Integer quantidadeDeParcelas;
    private final Double IGPM = 3.79;
    private Double jurosVenda;
    private Double valorTotal;
    private Double entrada;

    public void calcularValorTotal(Imovel imovel) {
        if (imovel.getStatus().equals("Venda")) {
            valorTotal = imovel.getValor() * (1 + (jurosVenda / 100));
        } else {
            if (quantidadeDeParcelas >= 12) {
                Integer quantParcelasComJurosAnual = quantidadeDeParcelas - 12;
                Double valorJurosTotal = quantParcelasComJurosAnual * imovel.getValor() * (IGPM / 100);
                valorTotal = imovel.getValor() + valorJurosTotal;
            } else {
                valorTotal = imovel.getValor() + quantidadeDeParcelas;
            }
        }
    }

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
