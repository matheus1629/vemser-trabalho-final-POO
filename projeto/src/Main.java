public class Main {
    public static void main(String[] args) {

        Corretor cr = new Corretor();
        ImovelAluguel im1 = new ImovelAluguel();
        im1.setQuantidadeDeComodos(5);
        ImovelAluguel im2 = new ImovelAluguel();
        im2.setQuantidadeDeComodos(3);
        cr.fecharContratoAluguel(im1);
        cr.fecharContratoAluguel(im2);
//        cr.exibirContratosDeAluguel();
        System.out.println(cr.getImoveisAluguel());
    }

}