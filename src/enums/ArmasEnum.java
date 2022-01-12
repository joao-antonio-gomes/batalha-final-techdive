package enums;

public enum ArmasEnum {
    ESPADA(1, "Espada", 10, "jogador"),
    MACHADO(2, "Machado", 12, "jogador"),
    MARTELO(3, "Martelo", 9, "jogador"),
    CLAVA(4, "Clava", 11, "jogador"),
    ARCO(5, "Arco", 11, "jogador"),
    BESTA(6, "Besta", 13, "jogador"),
    CAJADO(7, "Cajado", 12, "jogador"),
    LIVRO_DE_MAGIAS(8, "Livro de Magias", 13, "jogador"),
    ARMADILHA(9, "Armadilha", 15, "armadilha"),
    MACHADO_DUPLO(10, "Machado Duplo", 16, "chefe");

    private int id;
    private String nome;
    private int dano;

    private ArmasEnum(int id, String nome, int dano) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }
}
