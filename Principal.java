import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Seja Bem-Vindo!!\n" +
                "Começe digitando o limite do seu cartão");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int opcao;
        do {
            System.out.println("Digite a descrição da compra:");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!\n" +
                        "Deseja continuar?\n" +
                        "1. Sim  0. Não\n");
                opcao = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                opcao = 0;
            }
        } while (opcao != 0);

        System.out.println("========================\n" +
                "Compras realizadas com sucesso!!");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " +c.getValor());
        }
        System.out.println("\n========================");

        System.out.println("\nSaldo do cartão: " +cartao.getSaldo());
    }


}