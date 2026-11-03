package cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class LancheTest {

    @Test
    void deveRejeitarPrecoNegativo(){

        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("X-Burger", -16.00);
        });
    }
    @Test
    void deveCalcularPrecoComCheddar() {
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());
        assertEquals(26.00, lanche.getPreco(), 0.001);

    }
    @Test
    void deveRemoveringrediente(){
        Lanche lanche = new Lanche("X-Burger", 16.00);
        lanche.adicionarIngrediente("alface");
        lanche.adicionarIngrediente("queijo");
        lanche.removerIngrediente("alface");
        assertEquals(1, lanche.getIngredientes().size());
    }
    @Test
    void deveCriarXBurgerComDoisIngredientes(){
        Lanche lanche = LancheFactory.xBurger();
        assertEquals(2, lanche.getIngredientes().size());

    }
    @Test
    void deveMostrarDescricaoSemQueijo() {
        Lanche lanche = LancheFactory.xBurger();

        lanche.setQueijo(false);

        assertEquals("X-Burger sem queijo", lanche.getDescricao());
    }
}
