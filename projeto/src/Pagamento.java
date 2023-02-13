public class Pagamento {
    private Integer quantidadeDeParcelas;
    private Integer quantidadeDeParcelasJaPagas = 0;
    private final Double IGPM = 3.79;
    private Double jurosVenda;
    private Double valorTotal;
    private Double entrada = 0.0;

    public Pagamento(){

    }

    public void calcularValorTotal(Imovel imovel) {
        if (imovel.getStatus().toLowerCase().equals("venda")) {
            valorTotal = imovel.getValor() * (1 + (jurosVenda / 100));
        } else {
            if (getQuantidadeDeParcelasJaPagas() >= 12) {
                Integer quantParcelasComJurosAnual = quantidadeDeParcelas - 12;
                Double valorJurosTotal = quantParcelasComJurosAnual * imovel.getValor() * (IGPM / 100);
                valorTotal = imovel.getValor() + valorJurosTotal;
            } else {
                valorTotal = imovel.getValor();
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

    public Integer getQuantidadeDeParcelasJaPagas() {
        return quantidadeDeParcelasJaPagas;
    }

    private void setQuantidadeDeParcelasJaPagas(Integer quantidadeDeParcelasJaPagas) {
        this.quantidadeDeParcelasJaPagas = quantidadeDeParcelasJaPagas;
    }

    public Double pagar(Imovel imovel){
        setQuantidadeDeParcelasJaPagas(getQuantidadeDeParcelasJaPagas()+1);
        if(imovel.getStatus().toLowerCase()=="venda"){
            return getValorTotal()/getQuantidadeDeParcelas();
        } else if (imovel.getStatus().toLowerCase()=="aluguel") {
            return  getValorTotal();
        }
        return 0.0;
    }
}
