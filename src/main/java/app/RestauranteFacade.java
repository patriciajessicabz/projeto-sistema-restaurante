package app;

// Importa as classes e interfaces do pacote cardapio.
import cardapio.*;

// Importa as classes responsáveis pelos pedidos.
import pedido.GerenciadorPedidos;
import pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {

    // Cria um gerenciador que será responsável por controlar os pedidos.
    private GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();

    // Cria um novo pedido usando o gerenciador e retorna esse pedido.
    public Pedido criarPedido(String nomeCliente) {

        Pedido novoPedido = gerenciadorPedidos.criarPedido(nomeCliente);

        return novoPedido;
    }

    // Retorna o valor total de todos os pedidos do dia.
    public double calcularTotalDoDia() {

        return gerenciadorPedidos.calcularTotalDoDia();
    }

    // Retorna a quantidade de tipos diferentes de lanches vendidos no dia.
    public int contarTiposDeLanches() {
        return gerenciadorPedidos.contarTiposDeLanches();
    }

    // Retorna as combinações diferentes de lanches registradas no dia.
    public Collection<String> getCombinacoesDiferentesDoDia() {
        return gerenciadorPedidos.getCombinacoesDiferentesDoDia();
    }

    // Retorna a coleção de todos os pedidos cadastrados.
    public Collection<Pedido> getPedidos() {

        return gerenciadorPedidos.getPedidos();
    }

    // Busca um pedido pelo número informado.
    public Pedido buscarPedido(int numero) {

        return gerenciadorPedidos.buscarPedido(numero);
    }

    // Solicita ao gerenciador que cancele o pedido informado.
    // Retorna true ou false, conforme o resultado do cancelamento.
    public boolean cancelarPedido(int numero) {
        return gerenciadorPedidos.cancelarPedido(numero);
    }

    // Cria um lanche de acordo com a opção escolhida no menu.
    public Lanche criarLanche(int numero) {

        switch (numero) {

            // Opção 1: cria um X-Burger.
            case 1:
                return LancheFactory.xBurger();

            // Opção 2: cria um X-Salada.
            case 2:
                return LancheFactory.xSalada();

            // Opção 3: cria um X-Bacon.
            case 3:
                return LancheFactory.xBacon();

            // Se a opção não corresponder a nenhum lanche,
            // lança uma exceção informando que a opção é inválida.
            default:
                throw new IllegalArgumentException("Opção de lanche inválida.");
        }
    }

    // Adiciona um lanche ao pedido indicado pelo número.
    public void adicionarLancheAoPedido(int numeroPedido, ItemCardapio lanche) {

        // Busca o pedido que receberá o lanche.
        Pedido pedido = buscarPedido(numeroPedido);

        // Verifica se o pedido foi encontrado.
        if (pedido != null) {

            // Se encontrou, adiciona o lanche ao pedido.
            pedido.adicionarItem(lanche);

        } else {

            // Se não encontrou, informa que o pedido não existe.
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
    }

    // Aplica um adicional ao item do cardápio conforme a opção escolhida.
    public ItemCardapio aplicarAdicional(ItemCardapio item, int opcaoAdicional) {

        switch (opcaoAdicional) {

            // Opção 1: adiciona cheddar ao item.
            case 1:
                return new ComCheddar(item);

            // Opção 2: adiciona bacon extra ao item.
            case 2:
                return new ComBaconExtra(item);

            // Opção 0: mantém o item sem adicional.
            case 0:
                return item;

            // Se a opção não for válida, lança uma exceção.
            default:
                throw new IllegalArgumentException("Opção de adicional inválida.");
        }
    }
}


