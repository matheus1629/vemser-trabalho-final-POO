import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Administracao {
    private List<ImovelAluguel> listaImoveisAluguel = new ArrayList<>();
    private List<ImovelVenda> listaImoveisVenda = new ArrayList<>();
    private Double comissao; //fazer método pegando o valorTotal de ImovelVenda e ImovelAluguel e aplicar a comissão para cada tipo.
    private Double contasAReceber; // (quantidade de parcelas a serem recebidas)
    private List<Contrato> listaContratos = new ArrayList<>();


}
