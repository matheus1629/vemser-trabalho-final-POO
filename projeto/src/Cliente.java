import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario implements Impressao {
    private List<Double> boletos = new ArrayList<>();
    private List<Contrato> contratos = new ArrayList<>();

    public Cliente() {
    }



    public Cliente(String nome, String cpf, Contato contato, String loginUsuario, String senha) {
        super(nome, cpf, contato, loginUsuario, senha, "Cliente");

    }

    public static Cliente verificaCliente(List<Cliente> clientes, String loginUsuario, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getSenha().equals(senha) && cliente.getLoginUsuario().equals(loginUsuario)) {
                return cliente;
            }

        }
        return null;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public List<Double> getBoletos() {
        return boletos;
    }

    public void contratar(Contrato contrato) {
        this.contratos.add(contrato);
        this.boletos.add(contrato.getPagamento().pagar(contrato.getImovel()));
    }

    public void pagarParcela() {
        for (Contrato contrato : contratos) {
            this.boletos.add(contrato.getPagamento().pagar(contrato.getImovel()));
        }
    }

    @Override
    public void imprimirResumo() {

        System.out.println("Contratos de Aluguel:");
        for (Contrato contrato : contratos) {
            if (contrato.getImovel().getStatus().toLowerCase() == "aluguel") {
                System.out.println("Imóvel " + contrato.getImovel().getCodigo() + " - R$" + contrato.getPagamento().getValorTotal() + "/mês");
                System.out.println("Meses de locação: " + contrato.getPagamento().getQuantidadeDeParcelasJaPagas());
                System.out.println("=====================");
            }
        }
        System.out.println("Contratos de Venda:");
        for (Contrato contrato : contratos) {
            if (contrato.getImovel().getStatus().toLowerCase() == "venda") {
                System.out.println("Imóvel " + contrato.getImovel().getCodigo() + " - R$" + contrato.getPagamento().getValorTotal() + " com juros");
                System.out.println("Valor já pago: Entrada R$" + contrato.getPagamento().getEntrada() + " Parcelas pagas R$" + (contrato.getPagamento().getQuantidadeDeParcelasJaPagas() * (contrato.getPagamento().getValorTotal() - contrato.getPagamento().getEntrada()) / contrato.getPagamento().getQuantidadeDeParcelas()));
                System.out.println("=====================");
            }
        }

    }
}

