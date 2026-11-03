package pedido;

// Importa a interface que representa qualquer item do cardápio,
// como um lanche ou um lanche com adicional.
import cardapio.ItemCardapio;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

// Esta classe é responsável por gerenciar os pedidos do restaurante.
// Ela cria, busca, cancela e calcula informações sobre os pedidos.
public class GerenciadorPedidos {

    // HashMap armazena os pedidos usando o número do pedido como chave
    // e o objeto Pedido como valor.
    //
    // Exemplo:
    // Chave: 1
    // Valor: pedido do cliente Maria
    private HashMap<Integer, Pedido> pedidos = new HashMap<>();

    // Controla o número do próximo pedido.
    // Começa em 1 e aumenta a cada novo pedido criado.
    private int contadorPedidos = 1;

    // Cria um novo pedido para o cliente informado.
    public Pedido criarPedido(String nomeCliente) {

        // Cria um objeto Pedido usando o número atual do contador
        // e o nome do cliente.
        Pedido pedido = new Pedido(contadorPedidos, nomeCliente);

        // Armazena o pedido no HashMap.
        // O número do pedido é usado como chave.
        pedidos.put(pedido.getNumero(), pedido);

        // Incrementa o contador para que o próximo pedido
        // receba um número diferente.
        contadorPedidos++;

        // Retorna o pedido criado.
        return pedido;
    }

    // Busca um pedido pelo seu número.
    // Se o número não existir no HashMap, retorna null.
    public Pedido buscarPedido(int numero) {
        return pedidos.get(numero);
    }

    // Remove o pedido do HashMap.
    //
    // O método remove() retorna o pedido removido.
    // Se não existir um pedido com esse número, retorna null.
    //
    // Por isso, a comparação != null indica se o cancelamento
    // conseguiu remover um pedido.
    public boolean cancelarPedido(int numero) {
        return pedidos.remove(numero) != null;
    }

    // Retorna uma coleção com todos os pedidos armazenados.
    // values() retorna os valores do HashMap, ou seja, os objetos Pedido.
    public Collection<Pedido> getPedidos() {
        return pedidos.values();
    }

    // Calcula o valor total de todos os pedidos do dia.
    public double calcularTotalDoDia() {

        // Inicializa o total em zero.
        double total = 0;

        // Percorre todos os pedidos armazenados.
        for (Pedido p : pedidos.values()) {

            // Soma ao total o valor calculado de cada pedido.
            total += p.calcularTotal();
        }

        // Retorna a soma de todos os pedidos.
        return total;
    }

    // Conta quantas descrições diferentes de itens existem nos pedidos.
    public int contarTiposDeLanches() {

        // HashSet armazena valores sem duplicidade.
        // Se uma descrição for adicionada mais de uma vez,
        // ela será contabilizada apenas uma vez.
        HashSet<String> tipos = new HashSet<>();

        // Percorre todos os pedidos registrados.
        for (Pedido pedido : pedidos.values()) {

            // Percorre todos os itens de cada pedido.
            for (ItemCardapio item : pedido.getItens()) {

                // Adiciona a descrição do item ao HashSet.
                // Descrições repetidas não aumentam a quantidade.
                tipos.add(item.getDescricao());
            }
        }

        // Retorna a quantidade de descrições diferentes.
        return tipos.size();
    }

    // Retorna as combinações diferentes de itens registradas no dia.
    public HashSet<String> getCombinacoesDiferentesDoDia() {

        // Cria um HashSet para armazenar descrições sem duplicidade.
        HashSet<String> combinacoes = new HashSet<>();

        // Percorre todos os pedidos registrados.
        for (Pedido pedido : pedidos.values()) {

            // Percorre os itens de cada pedido.
            for (ItemCardapio item : pedido.getItens()) {

                // Adiciona a descrição do item ao conjunto.
                // Descrições iguais são armazenadas apenas uma vez.
                combinacoes.add(item.getDescricao());
            }
        }

        // Retorna o conjunto com as descrições diferentes.
        return combinacoes;
    }
}

/*
 * Resumo dos conceitos utilizados:
 *
 * HashMap:
 * Armazena os pedidos associando um número a cada objeto Pedido.
 * Isso facilita buscar ou cancelar um pedido pelo número.
 *
 * HashSet:
 * Armazena valores sem duplicidade.
 * Neste código, é usado para identificar descrições diferentes
 * de itens presentes nos pedidos.
 *
 * Collection:
 * É uma interface que permite retornar uma coleção de pedidos
 * sem exigir que quem recebe o resultado conheça a estrutura
 * específica utilizada para armazená-los.
 *
 * Responsabilidade da classe:
 * GerenciadorPedidos centraliza o gerenciamento dos pedidos.
 * A classe Main não precisa manipular diretamente o HashMap.
 */