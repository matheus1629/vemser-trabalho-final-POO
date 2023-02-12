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
        pagamento.calcularValorTotal(this.imovel);
        if(imovel.getStatus().toLowerCase()=="aluguel"){
            corretor.fecharContratoAluguel(imovel);
        } else if (imovel.getStatus().toLowerCase()=="venda") {
            corretor.fecharContratoVenda(imovel);
        }
        cliente.contratar(this);
        imovel.setDisponibilidade(false);
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
