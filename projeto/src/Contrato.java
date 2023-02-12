import java.util.List;

public class Contrato implements Pagamento {


    private ImovelVenda imovelVenda;
    private ImovelAluguel imovelAluguel;
    private Integer quantidadeParcelas;
    private final Double IGPM = 3.79;
    private Double jurosVenda;
    private Double valorTotal;
    private Corretor corretor;
    private Cliente cliente;
    private Double entrada;

    public Contrato(ImovelVenda imovelVenda, Integer quantidadeParcelas, Double jurosVenda, Double valorTotal, Corretor corretor, Cliente cliente) {
        this.imovelVenda = new ImovelVenda();
        this.quantidadeParcelas = quantidadeParcelas;
        this.jurosVenda = jurosVenda;
        this.valorTotal = valorTotal;
        this.corretor = corretor;
        this.cliente = cliente;
        calcularValorTotal();
    }

    public Contrato(ImovelAluguel imovelAluguel, Integer quantidadeParcelas, Double valorTotal, Corretor corretor, Cliente cliente) {
        this.imovelAluguel = new ImovelAluguel();
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorTotal = valorTotal;
        this.corretor = corretor;
        this.cliente = cliente;
        calcularValorTotal();
    }


    @Override
    public Double calcularValorTotal() {
        if (imovelVenda != null) {
            return valorTotal = imovelVenda.getValorImovel() * (jurosVenda / 100);
        } else {
            if (quantidadeParcelas >= 12) {
                Integer quantParcelasComJurosAnual = quantidadeParcelas - 12;
                Double valorJurosTotal = quantParcelasComJurosAnual * imovelVenda.getValorImovel() * (IGPM / 100);
                return valorTotal = imovelAluguel.getValorAluguel() + valorJurosTotal;
            } else {
                return valorTotal = imovelAluguel.getValorAluguel() * quantidadeParcelas;
            }
        }
    }

    public void setCorretor(Corretor corretor) {
        this.cliente = cliente;
    }
    public Corretor getCorretor() {
        return this.corretor;
    }

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public Double getEntrada() {
        return entrada;
    }
}
