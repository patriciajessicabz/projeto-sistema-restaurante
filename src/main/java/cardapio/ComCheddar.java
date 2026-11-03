package cardapio;

// Esta classe representa o adicional de cheddar.
// Ela implementa ItemCardapio para poder ser tratada como qualquer item do cardápio.
public class ComCheddar implements ItemCardapio {

    // Guarda o item original que receberá o adicional de cheddar.
    private ItemCardapio item;

    // O construtor recebe o item que será decorado com cheddar.
    // Exemplo: um X-Burger que receberá o adicional.
    public ComCheddar(ItemCardapio item) {
        this.item = item;
    }

    // Retorna a descrição do item original acrescentando " + cheddar".
    // Exemplo: "X-Burger + cheddar".
    public String getDescricao() {
        return item.getDescricao() + " + cheddar";
    }

    // Retorna o preço do item original somado ao valor do cheddar.
    // Neste caso, o adicional custa R$ 4,00.
    public double getPreco() {
        return item.getPreco() + 4.00;
    }
}

/*
 * Esta classe utiliza o padrão Decorator.
 *
 * O Decorator permite acrescentar características a um objeto
 * sem modificar a classe original.
 *
 * Aqui, ComCheddar envolve um item do cardápio e acrescenta
 * uma descrição e um preço referentes ao cheddar.
 *
 * Exemplo:
 * Item original: X-Burger — R$ 16,00
 * Com adicional: X-Burger + cheddar — R$ 20,00
 *
 * Se o item já tiver outro adicional, o cheddar pode ser aplicado
 * sobre ele também, somando os valores dos adicionais.
 */
