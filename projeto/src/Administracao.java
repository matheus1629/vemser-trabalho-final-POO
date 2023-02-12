import java.util.ArrayList;
import java.util.List;

public class Administracao implements Financeiro {
    private List<ImovelAluguel> listaImoveisAluguel = new ArrayList<>();
    private List<ImovelVenda> listaImoveisVenda = new ArrayList<>();
    private List<Contrato> listaContratos = new ArrayList<>();
    private Double comissao; //fazer método pegando o valorTotal de ImovelVenda e ImovelAluguel e aplicar a comissão para cada tipo.
    private Double contasAReceber; // (quantidade de parcelas a serem recebidas)

    @Override
    public Double calcularComissao(String corretor) { //
        List<Contrato> listaComisao = listaContratos.stream()
                .filter(corretorFiltro -> corretorFiltro.getCorretor().getNome() == corretor)
                .toList();

        for (Contrato listaValorComissao : listaComisao) {
            this.comissao += listaValorComissao.getValorTotal();
        }

        return this.comissao;
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
