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
        Contrato contratoTesteVenda = new Contrato(imovelTesteVenda,corretor1,cliente1,pagamento1);
        adm.incluirNovoContrato(contratoTesteVenda);
//        Pagamento pagamento2 = new Pagamento();
//        pagamento2.setQuantidadeDeParcelas(12);
//        Contrato contratoTesteAluguel = new Contrato(imovelTesteAluguel,corretor1,cliente1,pagamento2);
//        adm.incluirNovoContrato(contratoTesteAluguel);

        cliente1.imprimirResumo();
        cliente1.pagarParcela();
        cliente1.imprimirResumo();
        cliente1.pagarParcela();
        cliente1.imprimirResumo();
        corretor1.imprimirResumo();
//        System.out.println(adm.calcularContasAReceber());


        //cliente pode se cadastrar(no BD), ver listas de imoveis disponiveis, contratar um serviço e ver resumo da conta
        //corretor pode cadastrar imóvel e ver resumo da conta
        //adm cria contrato,

    }

}