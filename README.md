# Projeto: Simulação de Venda (GRASP - Alta Coesão)

Este é um projeto acadêmico simples em Java, desenvolvido para simular o back-end de um sistema de Ponto de Venda (PDV). O foco principal é demonstrar a aplicação de princípios de design, especialmente o padrão GRASP **Alta Coesão** (High Cohesion).

## 🚀 Funcionalidades Principais

  * **Simulação de Venda:** Permite adicionar itens a uma venda.
  * **Controle de Estoque:** Verifica a disponibilidade do produto no estoque antes de adicioná-lo à venda e realiza a baixa após a confirmação.
  * **Múltiplos Métodos de Pagamento:** Suporta diferentes formas de pagamento (Crédito, Débito, Pix/Dinheiro), aplicando taxas ou descontos específicos para cada um.
  * **Cálculo de Totais:** Calcula o total dos itens e o valor final a ser pago com base no método de pagamento.
  * **Apresentação no Console:** Exibe uma "Nota de Venda" formatada diretamente no console.
  * **Banco de Dados Simulado:** Utiliza a classe `DBMock` para simular o armazenamento de produtos, estoque e formas de pagamento.

## ⚙️ Como Executar

Este projeto é uma aplicação de console Java padrão.

1.  **Pré-requisitos:**

      * Java Development Kit (JDK) 21 ou superior (com base no arquivo `.classpath`).

2.  **Compilação e Execução (via terminal):**

    ```bash
    # Navegue até a pasta raiz do projeto (GRASP_High_Cohesion)

    # Compile os arquivos .java da pasta 'src' para a pasta 'bin'
    javac -d bin -cp src src/model/*.java src/view/*.java

    # Execute a classe principal
    java -cp bin view.Main
    ```

3.  **Execução (via Eclipse/IDE):**

      * Importe o projeto como um projeto Java existente.
      * Localize o arquivo `src/view/Main.java`.
      * Clique com o botão direito e selecione "Run As" \> "Java Application".

## 📂 Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

  * `src/model/`: Contém toda a lógica de negócio e as entidades do sistema.

      * `Sale.java`: Classe principal que gerencia os itens da venda e o pagamento.
      * `SaleItem.java`: Representa um item individual dentro da venda (Produto + Quantidade).
      * `Product.java`: Representa um produto (Descrição, Preço).
      * `Payment.java` (Interface): Define o contrato para os métodos de pagamento.
      * `CreditCard.java`, `DebitCard.java`, `Cash.java`: Implementações concretas da interface `Payment`.
      * `DBMock.java`: Simula um banco de dados (HashMap) para produtos e pagamentos.
      * `SalePresenter.java` (Interface): Define o contrato para a exibição da venda.

  * `src/view/`: Contém as classes responsáveis pela interação com o usuário (neste caso, o console).

      * `Main.java`: Ponto de entrada da aplicação. Cria a venda e chama o apresentador.
      * `ConsoleSalePresenter.java`: Implementação que formata e exibe os dados da venda no console.

## 💡 Princípios de Design (GRASP)

O nome do projeto (`GRASP_High_Cohesion`) destaca seu objetivo educacional.

### Alta Coesão (High Cohesion)

Este princípio sugere que as responsabilidades de uma classe devem ser focadas e relacionadas. No projeto, isso é observado em:

  * **`model.Sale`:** A classe `Sale` tem a responsabilidade exclusiva de gerenciar a lógica de uma venda (adicionar itens, calcular totais, processar pagamento, verificar estoque). Ela não se preocupa em *como* esses dados serão exibidos.
  * **`view.ConsoleSalePresenter`:** Esta classe tem a única responsabilidade de *apresentar* os dados de uma `Sale` no console. Ela não sabe como uma venda é criada, como o estoque é verificado ou como os totais são calculados.

Essa separação (lógica de negócio vs. lógica de apresentação) torna o sistema mais fácil de manter. Se quiséssemos criar uma interface gráfica (GUI) em vez de usar o console, poderíamos apenas criar um `GUISalePresenter` sem precisar alterar **nenhuma linha** de código no pacote `model`.
