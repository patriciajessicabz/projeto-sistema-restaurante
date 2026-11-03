package cardapio;

// Esta classe representa o adicional de bacon extra.
// Ela implementa ItemCardapio para que possa ser tratada como um item do cardápio.
public class ComBaconExtra implements ItemCardapio {

    // Guarda o item original que receberá o adicional.
    // Pode ser um X-Burger, X-Salada ou outro item que implemente ItemCardapio.
    private ItemCardapio item;

    // O construtor recebe o item que será decorado com bacon extra.
    // Assim, não precisamos criar um novo lanche do zero.
    public ComBaconExtra(ItemCardapio item) {
        this.item = item;
    }

    // Retorna a descrição do item original acrescentando " + bacon extra".
    // Exemplo: "X-Burger + bacon extra".
    public String getDescricao() {
        return item.getDescricao() + " + bacon extra";
    }

    // Retorna o preço do item original somado ao valor do bacon extra.
    // Neste caso, o adicional custa R$ 6,00.
    public double getPreco() {
        return item.getPreco() + 6.00;
    }
}

/*
 * Esta classe utiliza o padrão Decorator.
 *
 * O Decorator permite acrescentar características a um objeto
 * sem precisar modificar a classe original.
 *
 * Aqui, ComBaconExtra "envolve" um item do cardápio e acrescenta
 * uma descrição e um preço referentes ao bacon extra.
 *
 * Exemplo:
 * Item original: X-Burger — R$ 16,00
 * Com adicional: X-Burger + bacon extra — R$ 22,00
 */
