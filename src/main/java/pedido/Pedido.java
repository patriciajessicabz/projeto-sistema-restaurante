package pedido;

// Importa a interface que representa os itens do cardápio.
// Um item pode ser um lanche ou um lanche com adicionais.
import cardapio.ItemCardapio;

// Importa a classe Lanche.
// Ela está presente no código original, embora não seja utilizada nesta classe.
import cardapio.Lanche;

import java.util.ArrayList;

// A classe Pedido representa um pedido realizado por um cliente.
// Ela guarda o número do pedido, o nome do cliente e os itens escolhidos.
public class Pedido {

    // 1. Atributos

    // Identifica o pedido com um número.
    private int numero;

    // Armazena o nome do cliente que realizou o pedido.
    private String nomeCliente;

    // Lista que armazena os itens adicionados ao pedido.
    //
    // O tipo ItemCardapio permite guardar diferentes objetos que
    // implementam essa interface, como Lanche, ComCheddar e ComBaconExtra.
    private ArrayList<ItemCardapio> itens;


    // 2. Construtor

    // É executado quando um novo objeto Pedido é criado.
    // Recebe o número do pedido e o nome do cliente.
    public Pedido(int numero, String nomeCliente) {

        // Guarda o número recebido no atributo do pedido.
        this.numero = numero;

        // Define o nome do cliente usando o método de validação.
        setNomeCliente(nomeCliente);

        // Cria uma lista vazia para armazenar os itens do pedido.
        this.itens = new ArrayList<>();
    }


    // 3. Adicionar e remover itens

    // Adiciona um item à lista do pedido.
    // O item pode ser um lanche ou um lanche com adicionais.
    public void adicionarItem(ItemCardapio lanche) {
        itens.add(lanche);
    }

    // Remove da lista o item informado.
    // A remoção depende de encontrar o objeto correspondente na lista.
    public void removerItem(ItemCardapio lanche) {
        itens.remove(lanche);
    }

    // Remove um item da lista usando o número apresentado ao cliente.
    //
    // O número mostrado começa em 1, mas o índice de uma lista Java
    // começa em 0. Por isso, subtraímos 1 do número informado.
    public boolean removerItemPorNumero(int numeroItem) {

        // Converte o número do item para o índice da lista.
        int indice = numeroItem - 1;

        // Verifica se o índice está dentro dos limites da lista.
        if (indice >= 0 && indice < itens.size()) {

            // Remove o item que está na posição indicada.
            itens.remove(indice);

            // Retorna true para informar que a remoção foi realizada.
            return true;
        }

        // Se o número não corresponder a uma posição válida,
        // retorna false para informar que nada foi removido.
        return false;
    }


    // 4. Consultar a lista de itens

    // Retorna a lista de itens que fazem parte do pedido.
    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }


    // 5. Consultar o nome do cliente

    // Retorna o nome do cliente associado ao pedido.
    public String getNomeCliente() {
        return nomeCliente;
    }


    // 6. Consultar o número do pedido

    // Retorna o número que identifica o pedido.
    public int getNumero() {
        return numero;
    }


    // 7. Calcular o total do pedido

    // Soma o preço de todos os itens que estão no pedido.
    public double calcularTotal() {

        // Inicializa o valor total em zero.
        double total = 0;

        // Percorre todos os itens da lista.
        for (ItemCardapio lanche : itens) {

            // Obtém o preço de cada item e soma ao total.
            // Se o item tiver adicionais, o preço já considera esses adicionais.
            total += lanche.getPreco();
        }

        // Retorna o valor total do pedido.
        return total;
    }


    // 8. Validar e guardar o nome do cliente

    // Define o nome do cliente, verificando se ele é válido.
    public void setNomeCliente(String nomeCliente) {

        // Não permite que o nome seja null, vazio ou contenha apenas espaços.
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {

            // Lança uma exceção se o nome for inválido.
            throw new IllegalArgumentException(
                    "O nome do cliente não pode ser vazio."
            );
        }

        // Se o nome for válido, armazena-o no atributo.
        this.nomeCliente = nomeCliente;
    }
}

/*
 * Resumo da responsabilidade da classe:
 *
 * Pedido representa um pedido individual de um cliente.
 *
 * Ela é responsável por:
 * - guardar o número e o nome do cliente;
 * - armazenar os itens do pedido;
 * - adicionar e remover itens;
 * - consultar os dados do pedido;
 * - calcular o valor total;
 * - validar o nome do cliente.
 *
 * Relação com ItemCardapio:
 *
 * A lista utiliza a interface ItemCardapio em vez de guardar
 * somente objetos da classe Lanche.
 *
 * Isso permite que o pedido também armazene itens decorados,
 * como um lanche com cheddar ou bacon extra.
 *
 * Exemplo:
 * X-Burger: R$ 16,00
 * X-Burger com cheddar: R$ 20,00
 *
 * O método calcularTotal() chama getPreco() de cada item.
 * Assim, ele não precisa saber como o preço foi calculado.
 */