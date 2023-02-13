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
                    Cliente novoCliente = new Cliente();
                    System.out.println("Insira seu nome:");
                    novoCliente.setNome(sc.nextLine());
                    System.out.println("Insira seu CPF:");
                    novoCliente.setCpf(sc.nextLine());
                    Contato novoContato = new Contato();
                    System.out.println("Insira seu email para contato:");
                    novoContato.setEmail(sc.nextLine());
                    System.out.println("Insira seu telefone para contato:");
                    novoContato.setTelefone(sc.nextLine());
                    novoCliente.setContato(novoContato);
                    System.out.println("Insira seu nome de usuário:");
                    novoCliente.setLoginUsuario(sc.nextLine());
                    System.out.println("Insira sua senha:");
                    novoCliente.setSenha(sc.nextLine());
                    bd.adicionarCliente(novoCliente);
                }
            }else if(opc==2){
                System.out.println("Selecione uma opção: \n1 - Cadastrar imóvel \n2 - Editar um imóvel \n3 - Listar meus imóveis\n4 - Deletar um imóvel\n5 - Editar meu cadastro\n6 - Criar cadastro de corretor");
                opc = sc.nextInt();
                sc.nextLine();
                if(opc!=6){
                    System.out.println("Entre com seu nome de usuário:");
                    nomeUsuario = sc.nextLine();
                    System.out.println("Entre com sua senha:");
                    senha = sc.nextLine();
                    Corretor corretor = Corretor.verificaCorretor(bd.getListaDeCorretores(),nomeUsuario,senha);
                    if(corretor!=null && opc==1){
                        Endereco enderecoParaCadastro = new Endereco();
                        System.out.print("Digite o logradouro do imóvel: ");
                        enderecoParaCadastro.setLogradouro(sc.nextLine());
                        System.out.print("Digite o número do imóvel: ");
                        enderecoParaCadastro.setNumero(sc.nextLine());
                        System.out.print("Digite o CEP do imóvel: ");
                        enderecoParaCadastro.setCep(sc.nextLine());
                        System.out.print("Digite a cidade do imóvel: ");
                        enderecoParaCadastro.setCidade(sc.nextLine());
                        System.out.print("Digite o estado do imóvel: ");
                        enderecoParaCadastro.setEstado(sc.nextLine());
                        System.out.print("Digite o país do imóvel: ");
                        enderecoParaCadastro.setPais(sc.nextLine());
                        Imovel imovelParaCadastro = new Imovel();
                        imovelParaCadastro.setEndereco(enderecoParaCadastro);
                        System.out.print("Digite a quantidade de cômodos: ");
                        imovelParaCadastro.setQuantidadeDeComodos(sc.nextInt());
                        System.out.print("Digite o código do imóvel: ");
                        imovelParaCadastro.setCodigo(sc.nextInt());
                        System.out.print("Digite o valor do imóvel: ");
                        imovelParaCadastro.setValor(sc.nextDouble());
                        System.out.print("O imóvel é para aluguel ou venda? ");
                        imovelParaCadastro.setStatus(sc.nextLine().toLowerCase());
                        adm.cadastrarNovoImovel(imovelParaCadastro);
                        bd.adicionarImovel(imovelParaCadastro);
                    } else if (corretor!=null && opc==2){
                        adm.listarImoveis();
                        System.out.println("Insira o código do imóvel a ser editado:");
                        opc = sc.nextInt();
                        sc.nextLine();
                        int finalOpc1 = opc;
                        List<Imovel> imovel = adm.getListaImoveis().stream().filter(imv->imv.getCodigo()== finalOpc1).toList();
                        Imovel imovelEditar = imovel.get(0);

                        System.out.println("Qual informação gostaria de editar:\n1 - Tipo de contratação\n2 - Valor\n3 - Endereço\n");
                        opc = sc.nextInt();
                        sc.nextLine();
                        if(opc ==1){
                            System.out.println("Insira o tipo de contrato para o imóvel: aluguel ou venda?");
                            imovelEditar.setStatus(sc.nextLine());
                        }else if(opc==2){
                            System.out.printf("O valor atual é de R$%.2f",imovelEditar.getValor());
                            System.out.println("Qual o novo valor?");
                            imovelEditar.setValor(sc.nextDouble());
                            sc.nextLine();
                        }else {
                            System.out.println("Qual campo gostaria de mudar no endereço?\n1 - Logradouro\n2 - Número\n3 - CEP\n4 - Cidade\n5 - Estado\n6 - País");
                            opc=sc.nextInt();
                            sc.nextLine();
                            if(opc==1){
                                System.out.println("Digite novo logradouro:");
                                Endereco enderecoAux = imovelEditar.getEndereco();
                                enderecoAux.setLogradouro(sc.nextLine());
                                imovelEditar.setEndereco(enderecoAux);
                            } else if (opc==2) {
                                System.out.println("Digite novo número do endereço:");
                                Endereco enderecoAux = imovelEditar.getEndereco();
                                enderecoAux.setNumero(sc.nextLine());
                                imovelEditar.setEndereco(enderecoAux);
                            }else if (opc==3) {
                                System.out.println("Digite novo CEP:");
                                Endereco enderecoAux = imovelEditar.getEndereco();
                                enderecoAux.setCep(sc.nextLine());
                                imovelEditar.setEndereco(enderecoAux);
                            }else if (opc==4) {
                                System.out.println("Digite nova cidade:");
                                Endereco enderecoAux = imovelEditar.getEndereco();
                                enderecoAux.setCidade(sc.nextLine());
                                imovelEditar.setEndereco(enderecoAux);
                            }else if (opc==5) {
                                System.out.println("Digite novo estado:");
                                Endereco enderecoAux = imovelEditar.getEndereco();
                                enderecoAux.setEstado(sc.nextLine());
                                imovelEditar.setEndereco(enderecoAux);
                            }else {
                                System.out.println("Digite novo país:");
                                Endereco enderecoAux = imovelEditar.getEndereco();
                                enderecoAux.setPais(sc.nextLine());
                                imovelEditar.setEndereco(enderecoAux);
                            }
                        }
                    }else if(corretor!=null && opc==3){
                        corretor.imprimirResumo();
                    }else if(corretor!=null && opc==4){
                        adm.listarImoveis();
                        System.out.println("Insira o código do imóvel a ser deletado:");
                        opc = sc.nextInt();
                        sc.nextLine();
                        int finalOpc2 = opc;
                        List<Imovel> imovelADeletar = adm.getListaImoveis().stream().filter(imv->imv.getCodigo()== finalOpc2).toList();
                    }else if(corretor!=null && opc==5){

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