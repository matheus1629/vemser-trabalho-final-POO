import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Administracao adm = new Administracao();
        Contato contato1 = new Contato("(11) 9 9988-7766", "contato1@email.com");
        Contato contato2 = new Contato("(11) 9 9988-7755", "contato2@email.com");
        Cliente cliente1 = new Cliente("Carol","111.111.111-11",contato1,"carolinaImobiliaria","c@r0linaImobiliaria");
        Corretor corretor1 = new Corretor("Matheus", "222.222.222-22",contato2, "matheusCorretor", "m@th3usCorretor");
        Endereco endereco1 = new Endereco("Rua teste1", "134", "40.000-000", "São Paulo", "SP", "Brasil");
        Endereco endereco2 = new Endereco("Rua teste2", "135", "40.000-100", "São Paulo", "SP", "Brasil");
        Imovel imovelTesteVenda = new Imovel(endereco1,1,300000.0,"venda");
        Imovel imovelTesteAluguel = new Imovel(endereco1,2,1200.0,"aluguel");
        adm.cadastrarNovoImovel(imovelTesteVenda);
        adm.cadastrarNovoImovel(imovelTesteAluguel);
        Pagamento pagamento1 = new Pagamento();
        pagamento1.setEntrada(50000.0);
        pagamento1.setJurosVenda(3.98);
        pagamento1.setQuantidadeDeParcelas(3);
//        Contrato contratoTesteVenda = new Contrato(imovelTesteVenda,corretor1,cliente1,pagamento1);
//        adm.incluirNovoContrato(contratoTesteVenda);
        Pagamento pagamento2 = new Pagamento();
        pagamento2.setQuantidadeDeParcelas(12);
//        Contrato contratoTesteAluguel = new Contrato(imovelTesteAluguel,corretor1,cliente1,pagamento2);
//        adm.incluirNovoContrato(contratoTesteAluguel);

        Scanner sc = new Scanner(System.in);
        BancoDeDados bd = new BancoDeDados();
        bd.adicionarImovel(imovelTesteAluguel);
        bd.adicionarImovel(imovelTesteVenda);
        bd.adicionarCliente(cliente1);
        bd.adicionarCorretor(corretor1);

        int opc;
        String nomeUsuario;
        String senha;

        do {
            System.out.println("Entrar como: \n1 - Cliente\n2 - Corretor\n3 - Cancelar");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc == 1){
                System.out.println("Qual operação gostaria de realizar?\n1 - Se cadastrar\n2 - Contratar um serviço\n3 - Visualizar minhas informações\n4 - Editar meu cadastro");
                opc = sc.nextInt();
                sc.nextLine();
                if(opc!=1){
                    System.out.println("Entre com seu nome de usuário:");
                    nomeUsuario = sc.nextLine();
                    System.out.println("Entre com sua senha:");
                    senha = sc.nextLine();
                    Cliente cliente = Cliente.verificaCliente(bd.getListaDeClientes(),nomeUsuario,senha);
                    if(cliente!=null && opc==3){
                        cliente.imprimirResumo();
                    } else if (cliente!=null && opc==4) {
                        System.out.println("Qual informação você gostaria de editar?\n1 - Nome\n2 - CPF\n3 - email\n4 - telefone\n5 - nome de usuário\n6 - senha\n7 - Excluir meu cadastro");
                        opc = sc.nextInt();
                        sc.nextLine();
                        if(opc==1){
                            System.out.println("Novo nome:");
                            cliente.setNome(sc.nextLine());
                        }else if(opc==2){
                            System.out.println("CPF correto:");
                            cliente.setCpf(sc.nextLine());
                        } else if (opc==3) {
                            System.out.println("Novo email:");
                            Contato contato = new Contato();
                            contato = cliente.getContato();
                            contato.setEmail(sc.nextLine());
                            cliente.setContato(contato);
                        } else if (opc==4) {
                            System.out.println("Novo telefone:");
                            Contato contato = cliente.getContato();
                            contato.setTelefone(sc.nextLine());
                            cliente.setContato(contato);
                        } else if (opc==5) {
                            System.out.println("Insira novo nome de usuário");
                            cliente.setLoginUsuario(sc.nextLine());
                        }else if(opc==6){
                            System.out.println("Insira nova senha");
                            cliente.setSenha(sc.nextLine());
                        } else if (opc==7) {
                            bd.removerCliente(cliente);
                        } else {
                            System.out.println("Opção inválida");
                        }
                    }else if(opc == 2){
                        adm.imprimirResumo();
                        System.out.println("Qual o código do imóvel desejado?");
                        opc=sc.nextInt();
                        sc.nextLine();
                        int finalOpc = opc;
                        List<Imovel> imovel = adm.getListaImoveis().stream().filter(imv->imv.getCodigo()== finalOpc).toList();
                        Imovel imovel1 = imovel.get(0);
                        Pagamento pagamento = new Pagamento();
                        if(imovel1.getStatus().toLowerCase().equals("venda")){
                            pagamento = pagamento1;
                        }else {
                            pagamento = pagamento2;
                        }
                        Contrato contrato = new Contrato(imovel1,corretor1,cliente,pagamento);
                        adm.incluirNovoContrato(contrato);
                        cliente.imprimirResumo();
                    }
                }else{
                    Cliente cliente = new Cliente();
                    System.out.println("Insira seu nome:");
                    cliente.setNome(sc.nextLine());
                    System.out.println("Insira seu cpf:");
                    cliente.setCpf(sc.nextLine());
                    System.out.println("Insira seu email:");
                    Contato contato = new Contato();
                    contato.setEmail(sc.nextLine());
                    System.out.println("Insira seu telefone: ");
                    contato.setTelefone(sc.nextLine());
                    cliente.setContato(contato);
                    System.out.println("Escolha um nome de usuário:");
                    cliente.setLoginUsuario(sc.nextLine());
                    System.out.println("Escolha uma senha: ");
                    cliente.setSenha(sc.nextLine());
                    bd.adicionarCliente(cliente);
                }
            }
        }while(opc!=3);







//        System.out.println(adm.calcularContasAReceber());
//        cliente1.imprimirResumo();

        //cliente pode se cadastrar(no BD), ver listas de imoveis disponiveis, contratar um serviço e ver resumo da conta
        //corretor pode cadastrar imóvel e ver resumo da conta
        //adm cria contrato,




    }

}