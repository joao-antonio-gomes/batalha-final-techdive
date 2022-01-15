package enums;

import java.util.ArrayList;

public enum ArmasEnum {
    ESPADA(1, "Espada", 15, new ClassesEnum[]{ClassesEnum.GUERREIRO}),
    MACHADO(2, "Machado", 15, new ClassesEnum[]{ClassesEnum.GUERREIRO}),
    MARTELO(3, "Martelo", 13, new ClassesEnum[]{ClassesEnum.PALADINO}),
    CLAVA(4, "Clava", 13, new ClassesEnum[]{ClassesEnum.PALADINO}),
    ARCO(5, "Arco", 18, new ClassesEnum[]{ClassesEnum.ARQUEIRO}),
    BESTA(6, "Besta", 18, new ClassesEnum[]{ClassesEnum.ARQUEIRO}),
    CAJADO(7, "Cajado", 19, new ClassesEnum[]{ClassesEnum.MAGO}),
    LIVRO_DE_MAGIAS(8, "Livro de Magias", 19, new ClassesEnum[]{ClassesEnum.MAGO}),
    ARMADILHA(9, "Armadilha", 15, new ClassesEnum[]{}),
    MACHADO_DUPLO(10, "Machado Duplo", 16, new ClassesEnum[]{});

    private int id;
    private String nome;
    private int dano;
    private ClassesEnum[] usuariosPermitidos;

    private ArmasEnum(int id, String nome, int dano, ClassesEnum[] usuariosPermitidos) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.usuariosPermitidos = usuariosPermitidos;
    }

    public static ArrayList<ArmasEnum> getArmasByClasse(ClassesEnum classeEscolhida) {
        ArrayList<ArmasEnum> armas = new ArrayList<>();
        for (ArmasEnum arma : ArmasEnum.values()) {
            for (ClassesEnum classe : arma.usuariosPermitidos) {
                if (classe.equals(classeEscolhida)) {
                    armas.add(arma);
                }
            }
        }
        return armas;
    }

    public static ArmasEnum getArma(int arma) {
        for (ArmasEnum a : ArmasEnum.values()) {
            if (a.getId() == arma) {
                return a;
            }
        }
        return null;
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
