package enums;

public enum ArmasEnum {
    ESPADA(1, "Espada", 10),
    MACHADO(2, "Machado", 12),
    MARTELO(3, "Martelo", 9),
    CLAVA(4, "Clava", 11),
    ARCO(5, "Arco", 11),
    BESTA(6, "Besta", 13),
    CAJADO(7, "Cajado", 12),
    LIVRO_DE_MAGIAS(8, "Livro de Magias", 13),
    ARMADILHA(9, "Armadilha", 15),
    MACHADO_DUPLO(10, "Machado Duplo", 16);

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
