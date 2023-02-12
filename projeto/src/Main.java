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
        endereco1.setLogradouro("rua");
        endereco1.setLogradouro("numero");
        endereco1.setLogradouro("cidade");
        endereco1.setLogradouro("estado");
        endereco1.setLogradouro("pais");

        Imovel imovel1 = new Imovel(endereco1,"Disponível",120,1024,130000.00,"Aluguel");

        Cliente cliente = new Cliente();

            System.out.println("Login: ");
            login = scan.nextLine();
            System.out.println("Senha: ");
            senha = scan.nextLine();
            scan.nextLine();


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
//                    System.out.println("[1] Listar imóveis para alugar ");
//                    System.out.println("[2] Listar imóveis para venda");
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