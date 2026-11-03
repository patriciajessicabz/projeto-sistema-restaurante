package app;

// Importa a interface e a classe que representam os lanches
import cardapio.ItemCardapio;
import cardapio.Lanche;

// Importa a classe que representa um pedido
import pedido.Pedido;

// Importa as classes necessárias para coleções, tratamento de entrada inválida e leitura do teclado
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {

    // Cria o Scanner para receber as informações digitadas pelo usuário
    private Scanner sc = new Scanner(System.in);

    // Exibe as opções principais do sistema
    public void exibirMenu() {
        System.out.println("=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Editar pedido");
        System.out.println("5 - Cancelar pedido");
        System.out.println("0 - Sair");
    }

    // Lê a opção escolhida no menu principal
    public int lerOpcao() {
        try {
            // Tenta ler a entrada como um número inteiro
            int opcao = sc.nextInt();

            // Consome a quebra de linha que ficou no Scanner
            sc.nextLine();

            // Retorna a opção digitada
            return opcao;

        } catch (InputMismatchException e) {
            // Limpa a entrada inválida para permitir uma nova tentativa
            sc.nextLine();

            // Informa que o usuário precisa digitar um número
            System.out.println("Entrada inválida! Digite um número.");

            // Retorna -1 para a Main identificar que a entrada foi inválida
            return -1;
        }
    }

    // Pergunta se o cliente deseja determinado ingrediente
    public boolean perguntarIngrediente(String ingrediente) {

        // Repete a pergunta até receber S ou N
        while (true) {
            System.out.println("Deseja " + ingrediente + "?");
            System.out.println("S - Sim");
            System.out.println("N - Não");

            // Lê a resposta, remove espaços extras e armazena o texto
            String resposta = sc.nextLine().trim();

            // Se a resposta for S, retorna true
            if (resposta.equalsIgnoreCase("S")) {
                return true;
            }

            // Se a resposta for N, retorna false
            if (resposta.equalsIgnoreCase("N")) {
                return false;
            }

            // Se não for S nem N, informa o erro e pergunta novamente
            System.out.println("Entrada inválida! Digite S ou N.");
        }
    }

    // Recebe o nome do cliente
    public String lerNomeCliente() {
        System.out.println("Digite o nome do cliente:");

        // Lê o nome digitado
        String nomeCliente = sc.nextLine();

        // Retorna o nome para ser utilizado na criação do pedido
        return nomeCliente;
    }

    // Exibe o cardápio e recebe a opção de lanche
    public int lerOpcaoLanche() {
        System.out.println("=== CARDÁPIO DE LANCHES ===");
        System.out.println("1 - X-Burger — R$ 16,00");
        System.out.println("2 - X-Salada — R$ 18,00");
        System.out.println("3 - X-Bacon — R$ 22,00");

        try {
            // Tenta ler a opção como um número inteiro
            int opcaoLanche = sc.nextInt();

            // Consome a quebra de linha que ficou no Scanner
            sc.nextLine();

            // Retorna a opção escolhida
            return opcaoLanche;

        } catch (InputMismatchException e) {
            // Limpa a entrada inválida
            sc.nextLine();

            // Informa que o usuário deve digitar um número
            System.out.println("Entrada inválida! Digite um número.");

            // Retorna -1 para a Main identificar a entrada inválida
            return -1;
        }
    }

    // Recebe o número de um pedido
    public int lerNumeroPedido() {

        // Continua perguntando até receber um número inteiro
        while (true) {
            System.out.println("Digite o número do pedido:");

            try {
                // Tenta ler o número do pedido
                int numero = sc.nextInt();

                // Consome a quebra de linha
                sc.nextLine();

                // Retorna o número informado
                return numero;

            } catch (InputMismatchException e) {
                // Limpa a entrada inválida
                sc.nextLine();

                // Informa que o usuário deve digitar um número
                System.out.println("Entrada inválida! Digite o número do pedido.");
            }
        }
    }

    // Exibe os adicionais disponíveis e recebe a opção escolhida
    public int lerOpcaoAdicional() {
        System.out.println("=== ADICIONAIS ===");
        System.out.println("1 - Cheddar — R$ 4,00");
        System.out.println("2 - Bacon extra — R$ 6,00");
        System.out.println("0 - Nenhum adicional");

        // Repete a leitura até receber uma opção válida
        while (true) {
            try {
                // Tenta ler a opção como um número inteiro
                int opcaoAdicional = sc.nextInt();

                // Consome a quebra de linha
                sc.nextLine();

                // Aceita somente as opções de 0 a 2
                if (opcaoAdicional >= 0 && opcaoAdicional <= 2) {
                    return opcaoAdicional;
                }

                // Informa que o número está fora das opções permitidas
                System.out.println("Opção inválida! Digite 0, 1 ou 2.");

            } catch (InputMismatchException e) {
                // Limpa a entrada inválida, como letras
                sc.nextLine();

                // Informa que o usuário deve digitar um número válido
                System.out.println("Entrada inválida! Digite um número: 0, 1 ou 2.");
            }
        }
    }

    // Recebe o nome do ingrediente que o usuário deseja retirar
    public String lerIngredienteRemover() {
        System.out.println("Qual ingrediente deseja retirar? ");

        // Lê o ingrediente informado
        String ingrediente = sc.nextLine();

        // Retorna o ingrediente escolhido
        return ingrediente;
    }

    // Recebe o número do lanche que será removido
    public int lerNumeroItemRemover() {

        // Continua perguntando até receber um número inteiro
        while (true) {
            System.out.println("Digite o número do lanche que deseja remover:");

            try {
                // Tenta ler o número do lanche
                int numero = sc.nextInt();

                // Consome a quebra de linha
                sc.nextLine();

                // Retorna o número informado
                return numero;

            } catch (InputMismatchException e) {
                // Limpa a entrada inválida
                sc.nextLine();

                // Informa que o usuário deve digitar um número
                System.out.println("Entrada inválida! Digite o número do lanche.");
            }
        }
    }

    // Pergunta se o usuário deseja remover algum lanche
    public String perguntarRemoverLanche() {

        // Repete a pergunta até receber S ou N
        while (true) {
            System.out.println("Deseja remover algum lanche do pedido? (S/N)");

            // Lê a resposta e remove espaços extras
            String resposta = sc.nextLine().trim();

            // Aceita somente S ou N
            if (resposta.equalsIgnoreCase("S") ||
                    resposta.equalsIgnoreCase("N")) {
                return resposta;
            }

            // Informa que a resposta não é válida
            System.out.println("Entrada inválida! Digite S ou N.");
        }
    }

    // Exibe os dados e os itens de um pedido
    public void exibirPedido(Pedido pedido) {

        // Exibe o número do pedido e o nome do cliente
        System.out.println("Número do pedido: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());

        // Inicializa a numeração dos lanches que aparecem na comanda
        int numeroItem = 1;

        // Percorre os itens do pedido
        for (ItemCardapio lanche : pedido.getItens()) {

            // Exibe a descrição e o preço de cada lanche
            System.out.println(numeroItem + " - Lanche: " + lanche.getDescricao());
            System.out.println("Preço: " + lanche.getPreco());

            // Incrementa o número para o próximo lanche
            numeroItem++;
        }

        // Exibe o valor total do pedido
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
    }

    // Exibe o resumo do fechamento do dia
    public void exibirFechamentoDoDia(
            double total,
            int quantidadeTipos,
            Collection<String> combinacoes) {

        // Exibe o total vendido no dia
        System.out.println("Total vendido no dia: R$ " + total);

        // Exibe a quantidade de tipos diferentes de lanches vendidos
        System.out.println("Tipos diferentes de lanches vendidos: " + quantidadeTipos);

        // Exibe o título da lista de combinações
        System.out.println("Combinações vendidas:");

        // Percorre e exibe cada combinação diferente
        for (String combinacao : combinacoes) {
            System.out.println("- " + combinacao);
        }
    }

    // Exibe todos os pedidos cadastrados
    public void exibirPedidos(Collection<Pedido> pedidos) {

        // Percorre a coleção de pedidos
        for (Pedido pedido : pedidos) {

            // Reutiliza o método que exibe os detalhes de um pedido
            exibirPedido(pedido);
        }
    }

    // Pergunta se o usuário deseja adicionar outro lanche
    public String perguntarAdicionarOutroLanche() {

        // Repete a pergunta até receber S ou N
        while (true) {
            System.out.println("Deseja adicionar outro lanche? (S/N)");

            // Lê a resposta e remove espaços extras
            String resposta = sc.nextLine().trim();

            // Aceita somente S ou N
            if (resposta.equalsIgnoreCase("S") ||
                    resposta.equalsIgnoreCase("N")) {
                return resposta;
            }

            // Informa que a resposta é inválida
            System.out.println("Entrada inválida! Digite S ou N.");
        }
    }

    // Exibe as opções disponíveis para editar um pedido
    public int lerOpcaoEditarPedido() {

        // Repete a leitura até receber uma opção válida
        while (true) {
            System.out.println("=== EDITAR PEDIDO ===");
            System.out.println("1 - Adicionar lanche");
            System.out.println("2 - Remover lanche");
            System.out.println("0 - Voltar ao menu");
            System.out.println("Escolha uma opção:");

            try {
                // Tenta ler a opção como um número inteiro
                int opcao = sc.nextInt();

                // Consome a quebra de linha
                sc.nextLine();

                // Aceita somente as opções de 0 a 2
                if (opcao >= 0 && opcao <= 2) {
                    return opcao;
                }

                // Informa que a opção está fora do intervalo permitido
                System.out.println("Opção inválida! Digite 0, 1 ou 2.");

            } catch (InputMismatchException e) {
                // Limpa a entrada inválida
                sc.nextLine();

                // Informa que o usuário deve digitar um número
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }
}