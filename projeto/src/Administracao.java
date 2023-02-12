import java.util.ArrayList;
import java.util.List;

public class Administracao implements Financeiro {
    private List<Imovel> listaImoveisAluguel = new ArrayList<>();
    private List<Imovel > listaImoveisVenda = new ArrayList<>();
    private List<Imovel> listaImoveis = new ArrayList<>();
    private List<Contrato> listaContratos = new ArrayList<>();
    private Double comissao;
    private Double contasAReceber; // (quantidade de parcelas a serem recebidas)

    @Override
    public Double calcularTotalComissao() {
        Double comissaoTotalVenda = 0.0;

        List<Contrato> listaComissaTotalVenda = listaContratos.stream()
                .filter((listaVendas -> listaVendas.getImovel().getStatus() == "Venda")).toList();

        for (Contrato comissaoTotalComissao : listaComissaTotalVenda) {
             comissaoTotalVenda += comissaoTotalComissao.getPagamento().getValorTotal();
        }

        List<Contrato> listaComissaTotalAluguel = listaContratos.stream()
                .filter((listaAlugueis -> listaAlugueis.getImovel().getStatus() == "Aluguel")).toList();


        for (Contrato comissaoTotalComissao : listaComissaTotalAluguel) {
            comissaoTotalVenda += comissaoTotalComissao.getPagamento().getValorTotal();
        }

        return this.comissao = comissaoTotalVenda;
    }

    @Override
    public Double calcularContasAReceber() {
        Double totalVendido = 0.0;
        for (Contrato listaValorTotal : listaContratos) {
            totalVendido += listaValorTotal.getPagamento().getValorTotal();
        }

        Double totalEntrada = 0.0;
        for (Contrato listaValorTotal : listaContratos) {
            totalEntrada += listaValorTotal.getPagamento().getEntrada();
        }

        return this.contasAReceber = totalVendido - totalEntrada;
    }

    public List<Imovel> getListaImoveisAluguel() {
        return listaImoveisAluguel;
    }

    public void setListaImoveisAluguel(List<Imovel> listaImoveisAluguel) {
        this.listaImoveisAluguel = listaImoveisAluguel;
    }

    public List<Imovel> getListaImoveisVenda() {
        return listaImoveisVenda;
    }

    public void setListaImoveisVenda(List<Imovel> listaImoveisVenda) {
        this.listaImoveisVenda = listaImoveisVenda;
    }

    public List<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public void setListaImoveis(List<Imovel> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }

    public List<Contrato> getListaContratos() {
        return listaContratos;
    }

    public void setListaContratos(List<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public Double getContasAReceber() {
        return contasAReceber;
    }

    public void setContasAReceber(Double contasAReceber) {
        this.contasAReceber = contasAReceber;
    }
}
