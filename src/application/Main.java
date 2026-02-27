package application;

import entities.Investiment;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("----BEM VINDO, POR FAVOR, DIGITAR DADOS INICIAS:----");

        System.out.println("Digite seu nome completo: ");
        String name = scanner.nextLine();
        System.out.println("Digite seu saldo atual para verificação: ");
        double balance = scanner.nextDouble();

        Investiment investiment = new Investiment(name, balance);

        System.out.println();

        int comand = 0;
        while(comand != 5){
            System.out.println("\n===========MENU DE INVESTIMENTO================");
            System.out.println("Escreva um comando dos seguintes disponiveis: ");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Mostrar dados");
            System.out.println("4 - Alterar nome de usuário");
            System.out.println("5 - Sair");
            comand = scanner.nextInt();

            switch(comand){
                case 1:
                    System.out.println("______________$$$______________");
                    System.out.println("Escreva o valor a ser depositado: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    investiment.deposit(amount);
                    System.out.printf("Valor final: %.2f%n ", investiment.getBalance());
                    break;

                case 2:
                    System.out.println("______________$$$______________");
                    System.out.println("Digite o valor a ser sacado(Obs: para saques, possuimos uma taxa de 6% de IOF): ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    boolean success = investiment.withdraw(amount);

                    if (success) {
                        System.out.printf("Saque realizado! Saldo atual: %.2f%n", investiment.getBalance());
                    } else {
                        System.out.println("ERRO: Saldo insuficiente (não esqueça da taxa de 6%).");
                    }
                    break;

                case 3:

                    System.out.println("----------DADOS DO INVESTIDOR----------");
                    System.out.println(investiment);
                    System.out.println("---------------------------------------");
                    break;

               case 4:
                   System.out.println("----------------CONFIG----------------");
                   System.out.println("Digite o novo nome do titular: ");
                   scanner.nextLine();
                   String newName = scanner.nextLine();

                   if (investiment.updateName(newName)) {
                       System.out.println("Nome atualizado com sucesso!");
                   } else {
                       System.out.println("ERRO: O nome não pode ser vazio.");
                   }
                   break;

               case 5:
                   System.out.println("--------------------ATÉ MAIS--------------------");
                   break;

                default:
                    System.out.println("Comando inválido, voltando ao menu!...");
                    break;
                }
        }
        scanner.close();
    }
}
