package entities;

import util.FinanceUtils;

public class Investiment {
    // Encapsulamento para proteger o saldo de alterações externas
    private String holder;
    private double balance;

    public Investiment(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Erro: O valor deve ser positivo.");
        }
    }

    public boolean withdraw(double amount) {
        // Calcula o total considerando a taxa de IOF da classe utilitária
        double totalWithTax = amount + (amount * FinanceUtils.IOF);

        // Valida se há saldo suficiente ou se o valor inserido é inválido
        if (totalWithTax > this.balance || totalWithTax < 0) {
            return false;
        }

        this.balance -= totalWithTax;
        return true;
    }

    public void updateName(String newName) {
        // Evita nomes vazios ou compostos apenas por espaços
        if (newName.trim().isEmpty()) {
            System.out.println("Erro: Nome inválido.");
            return;
        }
        this.holder = newName;
    }

    // Getters necessários para leitura no Main
    public String getHolder() { return holder; }
    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return "Investidor(a): "
                + holder
                + " | Saldo atual: $ "
                + String.format("%.2f", balance);
    }
}