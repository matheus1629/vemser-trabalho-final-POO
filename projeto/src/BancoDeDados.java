import java.util.*;

public class BancoDeDados {
    private List<Corretor> listaDeCorretores = new ArrayList<>();
    private List<Cliente> listaDeClientes = new ArrayList<>();
    private List<Imovel> listaDeImoveis = new ArrayList<>();


    public void adicionarCorretor(Corretor corretor){
        this.listaDeCorretores.add(corretor);
    }

    public void adicionarCliente(Cliente cliente){
        this.listaDeClientes.add(cliente);
    }

    public void adicionarImovel(Imovel imovel){this.listaDeImoveis.add(imovel);}
    public void removerCorretor(Integer index){
        this.listaDeCorretores.remove(index.intValue());
    }
    public void removerCliente(Cliente cliente){
        this.listaDeClientes.remove(cliente);
    }
    public void removerImovel(Integer index){this.listaDeImoveis.remove(index.intValue());}

    public void editarCliente(Integer index, Cliente cliente){
        Cliente buscaCliente = listaDeClientes.get(index);
        // buscaCliente.setNome(cliente.getNome());

    }
    public void editarImoveis(Integer index,Imovel imovel){
        Imovel buscaImoveis = listaDeImoveis.get(index);
        buscaImoveis.setEndereco(imovel.getEndereco());
        buscaImoveis.setDisponibilidade(imovel.getDisponibilidade());
        buscaImoveis.setValor(imovel.getValor());
        buscaImoveis.setArea(imovel.getArea());
        buscaImoveis.setStatus(imovel.getStatus());
        buscaImoveis.setCodigo(imovel.getCodigo());
    }
    public void editarCorretor(Integer index,Corretor corretor){
        Corretor buscaCorretor = listaDeCorretores.get(index);
        buscaCorretor.setNome(corretor.getNome());
        buscaCorretor.setCpf(corretor.getCpf());
    }

    public void listarClientes() {
        for (int i = 0; i < listaDeClientes.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeClientes.get(i));
        }
    }

    public void listarCorretores() {
        for (int i = 0; i < listaDeCorretores.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeCorretores.get(i));
        }
    }

    public void listarImoveis() {
        for (int i = 0; i < listaDeImoveis.size(); i++) {
            if(listaDeImoveis.contains("Aluguel")){
                System.out.println(listaDeImoveis.contains("Aluguel"));
            }
            // System.out.println(listaDeImoveis.get(i));
        }
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }
}
