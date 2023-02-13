import java.util.*;

public class BancoDeDados {
    private List<Corretor> listaDeCorretores = new ArrayList<>();
    private List<Cliente> listaDeClientes = new ArrayList<>(
//            List.of(
//
//            )
    );
    private List<Imovel> listaDeImoveis = new ArrayList<>();


    public void adicionarCorretor(Corretor corretor){
        this.listaDeCorretores.add(corretor);
    }

    public void adicionarCliente(Cliente cliente){
        this.listaDeClientes.add(cliente);
    }

    public void adicionarImovel(Imovel imovel){this.listaDeImoveis.add(imovel);}
    public void removerCorretor(Corretor corretor){
        this.listaDeCorretores.remove(corretor);
    }
    public void removerCliente(Cliente cliente){
        this.listaDeClientes.remove(cliente);
    }
    public void removerImovel(Imovel imovel){this.listaDeImoveis.remove(imovel);}

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
        for (Corretor corretor: listaDeCorretores) {
            System.out.println(corretor.getNome());
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

    public List<Corretor> getListaDeCorretores() {
        return listaDeCorretores;
    }

    public Imovel getImovel(int codigo) {
        for (Imovel imovel:listaDeImoveis) {
            if(imovel.getCodigo()==codigo){
                return imovel;
            }
        }
        return null;
    }
}
