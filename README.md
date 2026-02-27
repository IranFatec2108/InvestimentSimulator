# 💸 Investiment Simulator - Java Core

Este projeto é um simulador de operações financeiras desenvolvido para consolidar os fundamentos de **Orientação a Objetos (POO)** e **Clean Code** no ecossistema Java. O foco principal foi a criação de uma lógica de negócio protegida e a aplicação de boas práticas de desenvolvimento backend.



## 🎯 Objetivo do Projeto
Demonstrar a transição técnica para a stack Java, aplicando conceitos de integridade de dados e encapsulamento que são essenciais em sistemas bancários e de investimentos.

### Detalhes da Implementação

- **Classe Investiment**: Gerencia o estado do investimento com métodos `deposit`, `withdraw` e `updateName`. O saque possui lógica de validação que impede saldos negativos e considera a taxa de IOF.
- **FinanceUtils**: Centraliza a constante `IOF = 0.06`, aplicando o conceito de membros estáticos.
- **Interface via Terminal**: Implementação de um menu interativo com `switch/case` e `while`, tratando a entrada de dados com a classe `Scanner`.

 ---
## 🧠 Diferenciais Técnicos (O que observar?)

### 1. Proteção de Estado (Encapsulamento)
Diferente de sistemas simples onde o saldo é alterado livremente, aqui o `balance` é privado. A alteração só ocorre através dos métodos `deposit()` e `withdraw()`, que validam se a operação é permitida.

### 2. Validação de Regras de Negócio
Implementação de lógicas de segurança para impedir:
* Saques superiores ao saldo disponível.
* Depósitos de valores negativos.
* Cadastro de titulares com nomes vazios ou inválidos (uso de `.trim()` e `.isEmpty()`).

### 3. Centralização de Constantes
Uso de uma classe utilitária para gerenciar taxas (como o IOF), facilitando a manutenção do código sem a necessidade de "números mágicos" espalhados pelo projeto.



## 📂 Estrutura do Repositório
```text
src/
 ├── application/  # Classe principal com o menu interativo
 ├── entities/     # Lógica de negócio e regras do investimento
 └── util/         # Constantes e fórmulas financeiras
