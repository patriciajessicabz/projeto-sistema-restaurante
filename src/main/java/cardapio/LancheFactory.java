package cardapio;

// A classe LancheFactory é responsável por criar os lanches do cardápio.
// Ela centraliza a criação dos objetos para que outras classes
// não precisem conhecer os detalhes de como cada lanche é montado.
public class LancheFactory {

    // Método static: pode ser chamado diretamente pela classe,
    // sem precisar criar um objeto LancheFactory.
    //
    // Cria e retorna um X-Burger com nome, preço e ingredientes definidos.
    public static Lanche xBurger() {

        // Cria um novo objeto Lanche com nome "X-Burger" e preço de R$ 16,00.
        Lanche lanche = new Lanche("X-Burger", 16.00);

        // Adiciona os ingredientes que fazem parte do X-Burger.
        lanche.adicionarIngrediente("alface");
        lanche.adicionarIngrediente("queijo");

        // Retorna o lanche criado para quem chamou o método.
        return lanche;
    }

    // Cria e retorna um X-Salada.
    public static Lanche xSalada() {

        // Cria um novo objeto Lanche com nome "X-Salada" e preço de R$ 18,00.
        Lanche lanche = new Lanche("X-Salada", 18.00);

        // Adiciona os ingredientes do X-Salada.
        lanche.adicionarIngrediente("alface");
        lanche.adicionarIngrediente("tomate");
        lanche.adicionarIngrediente("queijo");

        // Retorna o lanche criado.
        return lanche;
    }

    // Cria e retorna um X-Bacon.
    public static Lanche xBacon() {

        // Cria um novo objeto Lanche com nome "X-Bacon" e preço de R$ 22,00.
        Lanche lanche = new Lanche("X-Bacon", 22.00);

        // Adiciona os ingredientes do X-Bacon.
        lanche.adicionarIngrediente("bacon");
        lanche.adicionarIngrediente("queijo");
        lanche.adicionarIngrediente("alface");

        // Retorna o lanche criado.
        return lanche;
    }
}

/*
 * Como funciona o padrão Factory neste projeto?
 *
 * A Factory centraliza a criação dos lanches.
 *
 * Por exemplo, quando RestauranteFacade chama:
 *
 *     LancheFactory.xBurger();
 *
 * A Factory cria um X-Burger com o nome, o preço e os ingredientes
 * definidos neste método e devolve o objeto pronto.
 *
 * Assim, RestauranteFacade não precisa montar o lanche ingrediente
 * por ingrediente.
 *
 * Resumindo:
 * - Lanche representa o objeto lanche.
 * - LancheFactory cria os lanches.
 * - RestauranteFacade utiliza a Factory para solicitar a criação.
 */