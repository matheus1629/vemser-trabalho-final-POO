import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String login;
        String senha;
        int menuCliente =0;
        int menuCorretor =0;
        int opcao = 0;
        int opcaoCliente =0;
        int tipo;

        BancoDeDados manipularBanco = new BancoDeDados();

        Endereco endereco1 = new Endereco();
        endereco1.setLogradouro("AV Maurício Cardoso");
        endereco1.setNumero("1024");
        endereco1.setCidade("Novo Hamburgo");
        endereco1.setEstado("Rio Grande Do Sul");
        endereco1.setPais("Brasil");

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua Bartolomeu de Gusmão");
        endereco2.setNumero("124");
        endereco2.setCidade("Novo Hamburgo");
        endereco2.setEstado("Rio Grande Do Sul");
        endereco2.setPais("Brasil");

        Endereco endereco3 = new Endereco();
        endereco3.setLogradouro("AV Assis Brasil");
        endereco3.setNumero("2744");
        endereco3.setCidade("Novo Hamburgo");
        endereco3.setEstado("Rio Grande Do Sul");
        endereco3.setPais("Brasil");

        Endereco endereco4 = new Endereco();
        endereco4.setLogradouro("Rua Indaial");
        endereco4.setNumero("878");
        endereco4.setCidade("Novo Hamburgo");
        endereco4.setEstado("Rio Grande Do Sul");
        endereco4.setPais("Brasil");

        Imovel imovel1 = new Imovel(endereco1,"Disponível",120,1001,150000.00,"Aluguel");
        Imovel imovel2 = new Imovel(endereco2,"Indisponível",80,1002,135000.00,"Venda");
        Imovel imovel3 = new Imovel(endereco3,"Disponível",100,1003,80000.00,"Venda");
        Imovel imovel4 = new Imovel(endereco4,"Indisponível",90,1004,250000.00,"Aluguel");

        Cliente cliente = new Cliente();

            System.out.println("Login: ");
            login = scan.nextLine();
            System.out.println("Senha: ");
            senha = scan.nextLine();
            scan.nextLine();

        if(login.equals("cliente") && senha.equals("1234")){

            System.out.println("[1] Listar imóveis para alugar ");
            System.out.println("[2] Listar imóveis para venda");
            manipularBanco.adicionarImovel(imovel1);
            manipularBanco.adicionarImovel(imovel2);
            manipularBanco.adicionarImovel(imovel3);
            manipularBanco.adicionarImovel(imovel4);
            opcao = scan.nextInt();
            switch(opcao){
                case 1:
                   manipularBanco.listarImoveis();
                    break;
                case 2:

            }
        }
        else if(login.equals("corretor") && senha.equals("4321")){
            System.out.println("[1] Criar imovel");
            System.out.println("[2] Editar imovel");
            System.out.println("[3] Excluir imovel ");
        }
        else{System.out.println("Senha ou login inválidos");}
//        int opcao = 0;
//        while (opcao != 9) {
//            System.out.println("   MENU"    );
//            System.out.println("[1] Cliente");
//            System.out.println("[2] Corretor");
//            System.out.println("[9] Sair");
//            //System.out.println("Digite 9 para sair");
//
//            opcao = scan.nextInt();
//            scan.nextLine();
//            switch (opcao) {
//                case 1:

//
//
////                    Endereco endereco = new Endereco();
////                    Imovel imovel = new Imovel();
////
////                    manipularBanco.listarImovelAlguel();
////                    System.out.println("[1] Listar imóveis para alugar ");
////                    System.out.println("[2] Listar imóveis para venda");
////                    System.out.println("[3] Novo imóvel");
////                    System.out.println("[4] Excluir imóvel");
////
////                    opcaoSecundaria = scan.nextInt();
////
////                    switch(opcaoSecundaria){
////                        case 1: manipularBanco.listarImovelAlguel();
////                            scan.nextLine();
////                        break;
////                       }
//////                    Pessoa pessoa = new Pessoa();
//////                    System.out.println("Digite o nome da pessoa");
//////                    pessoa.setNome(scanner.nextLine());
//////                    System.out.println("Digite a idade da pessoa");
//////                    pessoa.setIdade(scanner.nextInt());
//////                    pessoaManipulacao.adicionarPessoa(pessoa);
//                    break;
//                case 2:
//                    System.out.println("[1] Criar imovel");
//                    System.out.println("[2] Editar imovel");
//                    System.out.println("[3] Excluir imovel ");
//
//                    break;
//                case 3:
////                    System.out.println("[1] Listar corretores");
////                    System.out.println("[2] Novo corretor");
////                    System.out.println("[3] Editar corretor");
////                    System.out.println("[3] Excluir corretor");
////                    System.out.println("Qual pessoa você deseja editar?");
////                    pessoaManipulacao.listarPessoas();
////                    int index = scanner.nextInt();
////                    scanner.nextLine();
////
////                    Pessoa pessoaNova = new Pessoa();
////                    System.out.println("Digite o novo nome da pessoa");
////                    pessoaNova.setNome(scanner.nextLine());
////                    System.out.println("Digite a nova idade da pessoa");
////                    pessoaNova.setIdade(scanner.nextInt());
////                    pessoaManipulacao.editarPessoa(index, pessoaNova);
//                   break;
//                case 4:
////                    System.out.println("Qual pessoa você deseja excluir?");
////                    pessoaManipulacao.listarPessoas();
////                    int id = scanner.nextInt();
////                    pessoaManipulacao.removerPessoaPorIndice(id);
////                    break;
//                case 0:
//                    break;
//                default:
//                    System.err.println("opção inválida");
//                    break;

//        Corretor cr = new Corretor();
//        ImovelAluguel im1 = new ImovelAluguel();
//        im1.setQuantidadeDeComodos(5);
//        ImovelAluguel im2 = new ImovelAluguel();
//        im2.setQuantidadeDeComodos(3);
//        cr.fecharContratoAluguel(im1);
//        cr.fecharContratoAluguel(im2);
////        cr.exibirContratosDeAluguel();
//        System.out.println(cr.getImoveisAluguel());
    }

}