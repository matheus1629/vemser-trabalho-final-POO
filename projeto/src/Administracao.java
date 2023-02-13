import java.util.ArrayList;
import java.util.List;

public class Administracao implements Financeiro,Impressao {
    private List<Imovel> listaImoveisAluguel = new ArrayList<>();
    private List<Imovel > listaImoveisVenda = new ArrayList<>();
    private List<Imovel> listaImoveis = new ArrayList<>();
    private List<Contrato> listaContratos = new ArrayList<>();
    private Double comissao;
    private Double contasAReceber; // (quantidade de parcelas a serem recebidas)

    @Override
    public Double calcularTotalComissao() {
        Double comissaoTotal = 0.0;

        List<Contrato> listaComissaTotalVenda = listaContratos.stream()
                .filter((listaVendas -> listaVendas.getImovel().getStatus().toLowerCase() == "venda")).toList();

        for (Contrato comissaoTotalComissao : listaComissaTotalVenda) {
             comissaoTotal += comissaoTotalComissao.getImovel().getValor()*0.01;
        }

        List<Contrato> listaComissaoTotalAluguel = listaContratos.stream()
                .filter((listaAlugueis -> listaAlugueis.getImovel().getStatus().toLowerCase() == "aluguel")).toList();


        for (Contrato comissaoTotalAluguel : listaComissaoTotalAluguel) {
            comissaoTotal += comissaoTotalAluguel.getImovel().getValor()*0.2;
        }

        return this.comissao = comissaoTotal;
    }

    @Override
    public Double calcularContasAReceber() {
        Double totalVendido = 0.0;
        for (Contrato listaValorTotal : listaContratos) {
            if(listaValorTotal.getImovel().getStatus().toLowerCase()=="venda"){
                totalVendido += listaValorTotal.getPagamento().getValorTotal();
            }else{
                totalVendido += listaValorTotal.getPagamento().getValorTotal()*listaValorTotal.getPagamento().getQuantidadeDeParcelas();
            }

        }
        Double totalEntrada = 0.0;
        for (Contrato listaValorTotal : listaContratos) {
            if(listaValorTotal.getImovel().getStatus().toLowerCase()=="venda"){
                totalEntrada += listaValorTotal.getPagamento().getEntrada();
            }else {
                totalEntrada += listaValorTotal.getPagamento().getQuantidadeDeParcelasJaPagas()*listaValorTotal.getPagamento().getValorTotal();
            }
        }

        return this.contasAReceber = totalVendido - totalEntrada;
    }

    public List<Imovel> getListaImoveisAluguel() {
        return listaImoveisAluguel;
    }

    private void incluirNovoImovelAluguel(Imovel imovelAluguel) {
        this.listaImoveisAluguel.add(imovelAluguel);
    }

    public List<Imovel> getListaImoveisVenda() {
        return listaImoveisVenda;
    }

    private void incluirNovoImovelVenda(Imovel imovelVenda) {
        this.listaImoveisVenda.add(imovelVenda);
    }

    public List<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    private void incluirNovoImovel(Imovel imovel) {
        this.listaImoveis.add(imovel);
    }

    public List<Contrato> getListaContratos() {
        return listaContratos;
    }

    public void incluirNovoContrato(Contrato contrato) {
        this.listaContratos.add(contrato);
    }

    public Double getComissao() {
        return comissao;
    }

    public Double getContasAReceber() {
        return contasAReceber;
    }

    public void cadastrarNovoImovel(Imovel imovel){
        incluirNovoImovel(imovel);
        if(imovel.getStatus().toLowerCase()=="aluguel"){
            incluirNovoImovelAluguel(imovel);
        }else {
            incluirNovoImovelVenda(imovel);
        }
    }

    @Override
    public void imprimirResumo() {
        System.out.println("Imóveis disponíveis: ");
        for (Imovel imovel: listaImoveis) {
            if(imovel.getDisponibilidade()){
                System.out.println("Imóvel "+imovel.getCodigo()+" disponível para "+imovel.getStatus());
            }
        }
    }
}
