package app;

// Importa a interface e a classe que representam os lanches
import cardapio.ItemCardapio;
import cardapio.Lanche;

// Importa a classe que representa um pedido
import pedido.Pedido;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        // Cria o objeto responsável pela interação com o usuário
        MenuConsole menu = new MenuConsole();

        // Cria o Facade, que centraliza o acesso às operações do sistema
        RestauranteFacade sistema = new RestauranteFacade();

        // Inicializa a opção com -1 para entrar no menu
        int opcao = -1;

        // Mantém o sistema funcionando enquanto o usuário não escolher sair
        while (opcao != 0) {

            // Exibe as opções disponíveis para o usuário
            menu.exibirMenu();

            // Recebe a opção escolhida pelo usuário
            opcao = menu.lerOpcao();

            // Se a entrada for inválida, volta ao início do menu
            if (opcao == -1) {
                continue;
            }

            // Direciona o programa conforme a opção escolhida
            switch (opcao) {

                // OPÇÃO 1: Cadastrar um novo pedido
                case 1: {

                    // Recebe o nome do cliente
                    String nomeCliente = menu.lerNomeCliente();

                    // Cria um novo pedido usando o Facade
                    Pedido pedido = sistema.criarPedido(nomeCliente);

                    // Escolhe o primeiro lanche do pedido
                    int opcaoLanche;

                    // Repete a pergunta enquanto a opção não for de 1 a 3
                    do {
                        opcaoLanche = menu.lerOpcaoLanche();
                    } while (opcaoLanche < 1 || opcaoLanche > 3);

                    // Cria o lanche escolhido
                    Lanche lanche = sistema.criarLanche(opcaoLanche);

                    // Personaliza o lanche: pergunta se o cliente deseja queijo
                    if (!menu.perguntarIngrediente("queijo")) {
                        lanche.setQueijo(false);
                    }

                    // Pergunta se o cliente deseja alface
                    if (!menu.perguntarIngrediente("alface")) {
                        lanche.setAlface(false);
                    }

                    // Pergunta se o cliente deseja tomate
                    if (!menu.perguntarIngrediente("tomate")) {
                        lanche.setTomate(false);
                    }

                    // Pergunta se o cliente deseja cebola
                    if (!menu.perguntarIngrediente("cebola")) {
                        lanche.setCebola(false);
                    }

                    // Escolhe o adicional do lanche
                    int opcaoAdicional;

                    // Repete a pergunta enquanto a opção não for de 0 a 2
                    do {
                        opcaoAdicional = menu.lerOpcaoAdicional();
                    } while (opcaoAdicional < 0 || opcaoAdicional > 2);

                    // Aplica o adicional escolhido ao lanche
                    // O resultado é armazenado usando a abstração ItemCardapio
                    ItemCardapio lancheComAdicional =
                            sistema.aplicarAdicional(lanche, opcaoAdicional);

                    // Adiciona o lanche personalizado ao pedido
                    sistema.adicionarLancheAoPedido(
                            pedido.getNumero(),
                            lancheComAdicional
                    );

                    // Pergunta se o cliente deseja adicionar outro lanche
                    String resposta = menu.perguntarAdicionarOutroLanche();

                    // Continua adicionando lanches enquanto a resposta for "S"
                    while (resposta.equalsIgnoreCase("S")) {

                        // Escolhe outro lanche
                        do {
                            opcaoLanche = menu.lerOpcaoLanche();
                        } while (opcaoLanche < 1 || opcaoLanche > 3);

                        // Cria o novo lanche escolhido
                        lanche = sistema.criarLanche(opcaoLanche);

                        // Personaliza o novo lanche
                        if (!menu.perguntarIngrediente("queijo")) {
                            lanche.setQueijo(false);
                        }

                        if (!menu.perguntarIngrediente("alface")) {
                            lanche.setAlface(false);
                        }

                        if (!menu.perguntarIngrediente("tomate")) {
                            lanche.setTomate(false);
                        }

                        if (!menu.perguntarIngrediente("cebola")) {
                            lanche.setCebola(false);
                        }

                        // Escolhe e aplica o adicional do novo lanche
                        opcaoAdicional = menu.lerOpcaoAdicional();

                        lancheComAdicional =
                                sistema.aplicarAdicional(lanche, opcaoAdicional);

                        // Adiciona o novo lanche ao mesmo pedido
                        sistema.adicionarLancheAoPedido(
                                pedido.getNumero(),
                                lancheComAdicional
                        );

                        // Pergunta se deseja continuar adicionando lanches
                        resposta = menu.perguntarAdicionarOutroLanche();
                    }

                    // Exibe a comanda completa do pedido
                    menu.exibirPedido(pedido);

                    // Pergunta se o cliente deseja remover algum lanche
                    String desejaRemover = menu.perguntarRemoverLanche();

                    // Se a resposta for "S", inicia o processo de remoção
                    if (desejaRemover.equalsIgnoreCase("S")) {

                        // Recebe o número do lanche que será removido
                        int numeroItem = menu.lerNumeroItemRemover();

                        // Tenta remover o lanche do pedido
                        boolean removido =
                                pedido.removerItemPorNumero(numeroItem);

                        // Informa se a remoção foi realizada
                        if (removido) {
                            System.out.println("Lanche removido com sucesso!");

                            // Exibe novamente o pedido atualizado
                            menu.exibirPedido(pedido);

                        } else {
                            // Informa que o número do lanche não é válido
                            System.out.println("Número de lanche inválido.");
                        }
                    }

                    // Finaliza a opção de cadastrar pedido
                    break;
                }

                // OPÇÃO 2: Listar os pedidos cadastrados
                case 2: {

                    // Obtém os pedidos do sistema e exibe a lista
                    menu.exibirPedidos(sistema.getPedidos());

                    break;
                }

                // OPÇÃO 3: Realizar o fechamento do dia
                case 3: {

                    // Calcula o valor total vendido no dia
                    double total = sistema.calcularTotalDoDia();

                    // Conta os tipos diferentes de lanches vendidos
                    int quantidadeTipos = sistema.contarTiposDeLanches();

                    // Obtém as combinações diferentes de lanches do dia
                    Collection<String> combinacoes =
                            sistema.getCombinacoesDiferentesDoDia();

                    // Exibe o resumo do fechamento do restaurante
                    menu.exibirFechamentoDoDia(
                            total,
                            quantidadeTipos,
                            combinacoes
                    );

                    break;
                }

                // OPÇÃO 4: Editar um pedido existente
                case 4: {

                    // Recebe o número do pedido que será editado
                    int numeroPedido = menu.lerNumeroPedido();

                    // Busca o pedido pelo número informado
                    Pedido pedido = sistema.buscarPedido(numeroPedido);

                    // Verifica se o pedido foi encontrado
                    if (pedido == null) {

                        System.out.println("Pedido não encontrado.");

                    } else {

                        // Exibe o pedido antes de realizar a edição
                        menu.exibirPedido(pedido);

                        // Recebe a opção de edição escolhida pelo usuário
                        int opcaoEdicao = menu.lerOpcaoEditarPedido();

                        // OPÇÃO 0: Sair da edição sem alterar o pedido
                        if (opcaoEdicao == 0) {
                            break;
                        }

                        // OPÇÃO 1: Adicionar um ou mais lanches ao pedido
                        if (opcaoEdicao == 1) {

                            int opcaoLanche;

                            // Escolhe o primeiro lanche que será adicionado
                            do {
                                opcaoLanche = menu.lerOpcaoLanche();
                            } while (opcaoLanche < 1 || opcaoLanche > 3);

                            // Cria o lanche escolhido
                            Lanche lanche = sistema.criarLanche(opcaoLanche);

                            // Personaliza os ingredientes do lanche
                            if (!menu.perguntarIngrediente("queijo")) {
                                lanche.setQueijo(false);
                            }

                            if (!menu.perguntarIngrediente("alface")) {
                                lanche.setAlface(false);
                            }

                            if (!menu.perguntarIngrediente("tomate")) {
                                lanche.setTomate(false);
                            }

                            if (!menu.perguntarIngrediente("cebola")) {
                                lanche.setCebola(false);
                            }

                            // Escolhe o adicional e aplica ao lanche
                            int opcaoAdicional = menu.lerOpcaoAdicional();

                            ItemCardapio lancheComAdicional =
                                    sistema.aplicarAdicional(
                                            lanche,
                                            opcaoAdicional
                                    );

                            // Adiciona o lanche ao pedido existente
                            sistema.adicionarLancheAoPedido(
                                    numeroPedido,
                                    lancheComAdicional
                            );

                            // Pergunta se deseja adicionar mais um lanche
                            String resposta =
                                    menu.perguntarAdicionarOutroLanche();

                            // Permite adicionar outros lanches ao mesmo pedido
                            while (resposta.equalsIgnoreCase("S")) {

                                // Escolhe um novo lanche
                                do {
                                    opcaoLanche = menu.lerOpcaoLanche();
                                } while (opcaoLanche < 1 || opcaoLanche > 3);

                                // Cria o novo lanche
                                lanche = sistema.criarLanche(opcaoLanche);

                                // Personaliza o novo lanche
                                if (!menu.perguntarIngrediente("queijo")) {
                                    lanche.setQueijo(false);
                                }

                                if (!menu.perguntarIngrediente("alface")) {
                                    lanche.setAlface(false);
                                }

                                if (!menu.perguntarIngrediente("tomate")) {
                                    lanche.setTomate(false);
                                }

                                if (!menu.perguntarIngrediente("cebola")) {
                                    lanche.setCebola(false);
                                }

                                // Escolhe o adicional
                                do {
                                    opcaoAdicional =
                                            menu.lerOpcaoAdicional();
                                } while (opcaoAdicional < 0 || opcaoAdicional > 2);

                                // Aplica o adicional ao novo lanche
                                lancheComAdicional =
                                        sistema.aplicarAdicional(
                                                lanche,
                                                opcaoAdicional
                                        );

                                // Adiciona o novo lanche ao pedido
                                sistema.adicionarLancheAoPedido(
                                        numeroPedido,
                                        lancheComAdicional
                                );

                                // Pergunta se deseja adicionar mais um
                                resposta =
                                        menu.perguntarAdicionarOutroLanche();
                            }

                            // Exibe o pedido após a edição
                            menu.exibirPedido(pedido);
                        }

                        // OPÇÃO 2: Remover um lanche do pedido
                        if (opcaoEdicao == 2) {

                            // Exibe o pedido para consultar os itens
                            menu.exibirPedido(pedido);

                            // Recebe o número do lanche que será removido
                            int numeroItem = menu.lerNumeroItemRemover();

                            // Tenta remover o lanche do pedido
                            boolean removido =
                                    pedido.removerItemPorNumero(numeroItem);

                            // Informa o resultado da remoção
                            if (removido) {
                                System.out.println("Lanche removido com sucesso!");

                            } else {
                                System.out.println("Número de lanche inválido.");
                            }

                            // Exibe o pedido atualizado
                            menu.exibirPedido(pedido);
                        }
                    }

                    // Finaliza a opção de edição
                    break;
                }

                // OPÇÃO 5: Cancelar um pedido
                case 5: {

                    // Recebe o número do pedido que será cancelado
                    int numeroPedido = menu.lerNumeroPedido();

                    // Solicita ao sistema o cancelamento do pedido
                    boolean cancelado = sistema.cancelarPedido(numeroPedido);

                    // Informa se o pedido foi cancelado
                    if (cancelado) {
                        System.out.println("Pedido cancelado com sucesso!");

                    } else {
                        // Informa que o pedido não foi encontrado
                        System.out.println("Pedido não encontrado.");
                    }

                    break;
                }

                // OPÇÃO 0: Encerrar o sistema
                case 0: {
                    break;
                }

                // Trata opções que não existem no menu
                default:
                    System.out.println(
                            "Opção inválida! Escolha uma opção do menu."
                    );
                    break;
            }
        }
    }
}