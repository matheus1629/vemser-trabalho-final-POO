public class Contrato{
    private Imovel imovel;
    private Corretor corretor;
    private Cliente cliente;
    private Pagamento pagamento;

    public Contrato(Imovel imovel, Corretor corretor, Cliente cliente, Pagamento pagamento) {
        this.imovel = imovel;
        this.corretor = corretor;
        this.cliente = cliente;
        this.pagamento = pagamento;
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        if (imovel.getStatus().equals("Venda")) {
            pagamento.setValorTotal(imovel.getValor() * (1 + (pagamento.getJurosVenda() / 100)));
        } else {
            if (pagamento.getQuantidadeDeParcelas() >= 12) {
                Integer quantParcelasComJurosAnual = pagamento.getQuantidadeDeParcelas() - 12;
                Double valorJurosTotal = quantParcelasComJurosAnual * imovel.getValor() * (pagamento.getIGPM() / 100);
                pagamento.setValorTotal(imovel.getValor() + valorJurosTotal);
            } else {
                pagamento.setValorTotal(imovel.getValor() + pagamento.getQuantidadeDeParcelas());
            }
        }
    }

    public Imovel getImovel() {
        return imovel;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
