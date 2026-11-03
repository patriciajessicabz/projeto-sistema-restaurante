package cardapio;

// Importa ArrayList, uma lista que permite armazenar vários ingredientes.
import java.util.ArrayList;

// A classe Lanche representa um lanche do cardápio.
// Ela implementa ItemCardapio, então precisa fornecer os métodos
// getDescricao() e getPreco() definidos nessa interface.
public class Lanche implements ItemCardapio {

    // Atributos que guardam o nome e o preço do lanche.
    private String nome;
    private double preco;

    // Ingredientes que vêm no lanche por padrão.
    // O valor true indica que o ingrediente está presente.
    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;

    // Lista que permite armazenar ingredientes adicionais ou personalizados.
    private ArrayList<String> ingredientes = new ArrayList<>();

    // Construtor: é executado quando um novo Lanche é criado.
    // Recebe o nome e o preço e utiliza os setters para atribuí-los.
    public Lanche(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    // Adiciona um ingrediente à lista de ingredientes.
    public void adicionarIngrediente(String ingrediente) {
        ingredientes.add(ingrediente);
    }

    // Remove um ingrediente da lista.
    // O remove() procura e remove a primeira ocorrência do ingrediente informado.
    public void removerIngrediente(String ingrediente) {
        ingredientes.remove(ingrediente);
    }

    // Retorna a lista de ingredientes armazenados no lanche.
    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    // Define o nome do lanche.
    // Valida se o nome não é null, vazio ou composto apenas por espaços.
    // Se for inválido, lança uma exceção e não atribui o valor.
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        this.nome = nome;
    }

    // Define o preço do lanche.
    // Não permite que o preço seja negativo.
    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }

        this.preco = preco;
    }

    // Retorna o nome do lanche.
    public String getNome() {
        return nome;
    }

    // Retorna o preço do lanche.
    // Este método também atende ao contrato da interface ItemCardapio.
    public double getPreco() {
        return preco;
    }

    // Monta e retorna a descrição do lanche.
    // Começa com o nome e acrescenta as informações dos ingredientes removidos.
    // Exemplo: "X-Burger sem queijo sem cebola".
    public String getDescricao() {
        String descricao = nome;

        // Se queijo for false, informa que o lanche está sem queijo.
        if (!queijo) {
            descricao += " sem queijo";
        }

        // Se alface for false, informa que o lanche está sem alface.
        if (!alface) {
            descricao += " sem alface";
        }

        // Se tomate for false, informa que o lanche está sem tomate.
        if (!tomate) {
            descricao += " sem tomate";
        }

        // Se cebola for false, informa que o lanche está sem cebola.
        if (!cebola) {
            descricao += " sem cebola";
        }

        return descricao;
    }

    // Define se o lanche terá queijo.
    // true significa que tem queijo; false significa que não tem.
    public void setQueijo(boolean queijo) {
        this.queijo = queijo;
    }

    // Informa se o lanche tem queijo.
    // Métodos boolean geralmente utilizam o prefixo is.
    public boolean isQueijo() {
        return queijo;
    }

    // Define se o lanche terá alface.
    public void setAlface(boolean alface) {
        this.alface = alface;
    }

    // Informa se o lanche tem alface.
    public boolean isAlface() {
        return alface;
    }

    // Define se o lanche terá tomate.
    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    // Informa se o lanche tem tomate.
    public boolean isTomate() {
        return tomate;
    }

    // Define se o lanche terá cebola.
    public void setCebola(boolean cebola) {
        this.cebola = cebola;
    }

    // Informa se o lanche tem cebola.
    public boolean isCebola() {
        return cebola;
    }
}

/*
 * Relação com a interface ItemCardapio:
 *
 * Como Lanche implementa ItemCardapio, ela fornece os métodos
 * getDescricao() e getPreco().
 *
 * Isso permite que um Lanche seja usado onde o sistema espera
 * um ItemCardapio, inclusive nos adicionais ComCheddar e ComBaconExtra.
 *
 * Observação:
 * Os ingredientes queijo, alface, tomate e cebola são controlados
 * pelos atributos boolean.
 *
 * A lista ingredientes é uma estrutura separada. Neste código,
 * adicionarIngrediente() e removerIngrediente() modificam essa lista,
 * mas não alteram os atributos boolean nem a descrição gerada por getDescricao().
 */