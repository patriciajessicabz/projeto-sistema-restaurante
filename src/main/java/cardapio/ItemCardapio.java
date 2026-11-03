package cardapio;

// Interface que define o comportamento que todo item do cardápio deve ter.
//
// Uma interface funciona como um contrato: qualquer classe que a implementar
// precisa fornecer os métodos declarados aqui.
//
// No projeto, esse contrato permite que lanches e adicionais sejam tratados
// de maneira padronizada, mesmo que sejam classes diferentes.
public interface ItemCardapio {

    // Define que todo item do cardápio deve informar sua descrição.
    // Exemplo: "X-Burger + cheddar".
    String getDescricao();

    // Define que todo item do cardápio deve informar seu preço.
    // Exemplo: 20.00.
    double getPreco();
}

/*
 * Relação com o padrão Decorator:
 *
 * ComCheddar e ComBaconExtra implementam esta mesma interface.
 * Assim, um adicional também pode ser tratado como um ItemCardapio.
 *
 * Isso permite aplicar um adicional sobre um lanche ou até sobre
 * outro adicional, sem precisar mudar a interface.
 */
