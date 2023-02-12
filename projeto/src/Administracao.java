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
             comissaoTotalVenda += comissaoTotalComissao.getValorTotal();
        }

        List<Contrato> listaComissaTotalAluguel = listaContratos.stream()
                .filter((listaAlugueis -> listaAlugueis.getImovel().getStatus() == "Aluguel")).toList();


        for (Contrato comissaoTotalComissao : listaComissaTotalAluguel) {
            comissaoTotalVenda += comissaoTotalComissao.getValorTotal();
        }

        return this.comissao = comissaoTotalVenda;
    }

    @Override
    public Double calcularContasAReceber() {
        Double totalVendido = 0.0;
        for (Contrato listaValorTotal : listaContratos) {
            totalVendido += listaValorTotal.getValorTotal();
        }

        Double totalEntrada = 0.0;
        for (Contrato listaValorTotal : listaContratos) {
            totalEntrada += listaValorTotal.getEntrada();
        }

        return this.contasAReceber = totalVendido - totalEntrada;
    }

}
