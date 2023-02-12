public class Contrato implements Pagamento{
    private Imovel imovel;
    private Integer quantidadeParcelas;
    private final Double IGPM = 3.79;
    private Double jurosVenda;
    private Double valorTotal;
    private Corretor corretor;
    private Cliente cliente;
    private Double entrada;

//    public Contrato(ImovelVenda imovel, Integer quantidadeParcelas, Double jurosVenda, Double valorTotal, Corretor corretor, Cliente cliente) {
//        this.imovel = new ImovelVenda();
//        this.quantidadeParcelas = quantidadeParcelas;
//        this.jurosVenda = jurosVenda;
//        this.valorTotal = valorTotal;
//        this.corretor = corretor;
//        this.cliente = cliente;
//    }

//    public Contrato(ImovelAluguel imovel, Integer quantidadeParcelas, Double valorTotal, Corretor corretor, Cliente cliente) {
//        this.imovel = new ImovelAluguel();
//        this.quantidadeParcelas = quantidadeParcelas;
//        this.valorTotal = valorTotal;
//        this.corretor = corretor;
//        this.cliente = cliente;
//    }
}
