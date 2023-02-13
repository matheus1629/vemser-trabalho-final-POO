import java.util.ArrayList;
import java.util.List;

public class Corretor extends Usuario implements Impressao{
    List<Imovel> imoveisAluguel = new ArrayList<>();
    List<Imovel> imoveisVenda = new ArrayList<>();
    List<Contrato> contratos = new ArrayList<>();
    private Double comissao;

    public Corretor(String nome, String cpf, Contato contato, String loginUsuario, String senha) {
        super(nome, cpf, contato, loginUsuario, senha, "Corretor");
    }
    public static Corretor verificaCorretor(List<Corretor>corretores, String loginUsuario, String senha){
        for (Corretor corretor:corretores) {
            if(corretor.getSenha().equals(senha)&&corretor.getLoginUsuario().equals(loginUsuario)){
                return corretor;
            }
        };
        return null;
    }

    private void setImovelAluguel(Imovel imovelAluguel) {
        this.imoveisAluguel.add(imovelAluguel);
    }

    private void setImovelVenda(Imovel imovelVenda) {
        this.imoveisVenda.add(imovelVenda);
    }

    private void setComissao() {
        this.comissao = 0.0;
        for (Imovel imovel: imoveisAluguel) {
            comissao+=imovel.getValor()*0.2;
        }
        for (Imovel imovel: imoveisVenda) {
            comissao+=imovel.getValor()*0.01;
        }
    }

    public List<Imovel> getImoveisAluguel() {
        return imoveisAluguel;
    }
    public List<Imovel> getImoveisVenda() {
        return imoveisVenda;
    }

    public Double getComissao() {
        return comissao;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    private void incluirContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }

    public void fecharContratoAluguel(Contrato contrato){
        incluirContrato(contrato);
        setImovelAluguel(contrato.getImovel());
        setComissao();
    }
    public void fecharContratoVenda(Contrato contrato){
        incluirContrato(contrato);
        setImovelVenda(contrato.getImovel());
        setComissao();
    }


    @Override
    public void imprimirResumo() {
        System.out.println("Meus Contratos");
        for (Contrato contrato:contratos) {
            System.out.println("Imóvel: "+ contrato.getImovel().getCodigo()+" \nTipo de contratação: "+contrato.getImovel().getStatus().toUpperCase()+" \nCliente: "+contrato.getCliente().getNome());
            System.out.println("=====================");
        }
        System.out.println("Minha comissão: R$"+comissao);
    }
}


