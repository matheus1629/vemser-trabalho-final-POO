import java.util.ArrayList;
import java.util.List;

public class Corretor extends Usuario{
    List<Imovel> imoveisAluguel = new ArrayList<>();
    List<Imovel> imoveisVenda = new ArrayList<>();
    private Double comissao;

    public Corretor(String nome, String cpf, Contato contato, String loginUsuario, String senha, String tipo) {
        super(nome, cpf, contato, loginUsuario, senha, "Corretor");
    }
    public Corretor verificaCorretor(List<Corretor>corretores, String loginUsuario, String senha){
        for (Corretor corretor:corretores) {
            if(corretor.getSenha()==senha&&corretor.getLoginUsuario()==loginUsuario){
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

    public void setComissao() {
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

    void fecharContratoAluguel(Imovel imovel){
        setImovelAluguel(imovel);
        setComissao();
    }
    void fecharContratoVenda(Imovel imovel){
        setImovelVenda(imovel);
        setComissao();
    }


}


