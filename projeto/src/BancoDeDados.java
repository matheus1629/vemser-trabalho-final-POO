import java.util.*;

public class BancoDeDados {
    private List<Corretor> listaDeCorretores = new ArrayList<>();
    private List<Cliente> listaDeClientes = new ArrayList<>();
    private List<Imovel> listaDeImoveis = new ArrayList<>();


    public void adicionarCorretor(Corretor corretor) {
        this.listaDeCorretores.add(corretor);
    }

    public void adicionarCliente(Cliente cliente) {
        this.listaDeClientes.add(cliente);
    }

    public void adicionarImovel(Imovel imovel) {
        this.listaDeImoveis.add(imovel);
    }

    public void removerCorretor(Corretor corretor) {
        this.listaDeCorretores.remove(corretor);
    }

    public void removerCliente(Cliente cliente) {
        this.listaDeClientes.remove(cliente);
    }

    public void removerImovel(Imovel imovel) {
        this.listaDeImoveis.remove(imovel);
    }

    public void listarCorretores() {
        for (Corretor corretor : listaDeCorretores) {
            System.out.println(corretor.getNome());
        }
    }

    public void listarImoveis() {
        for (Imovel imoveis : listaDeImoveis) {
            System.out.printf("Imóvel %d - Tipo de contratação: %s\n", imoveis.getCodigo(), imoveis.getStatus());

        }
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public List<Corretor> getListaDeCorretores() {
        return listaDeCorretores;
    }

    public Imovel getImovel(int codigo) {
        for (Imovel imovel : listaDeImoveis) {
            if (imovel.getCodigo() == codigo) {
                return imovel;
            }
        }
        return null;
    }
}
