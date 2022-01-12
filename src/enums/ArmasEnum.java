package enums;

import model.*;

import java.util.ArrayList;
import java.util.List;

public enum ArmasEnum {
    ESPADA(1, "Espada", 15, new ArrayList<Class>(List.of(Guerreiro.class))),
    MACHADO(2, "Machado", 15, new ArrayList<Class>(List.of(Guerreiro.class))),
    MARTELO(3, "Martelo", 13, new ArrayList<Class>(List.of(Paladino.class))),
    CLAVA(4, "Clava", 13, new ArrayList<Class>(List.of(Paladino.class))),
    ARCO(5, "Arco", 18, new ArrayList<Class>(List.of(Arqueiro.class))),
    BESTA(6, "Besta", 18, new ArrayList<Class>(List.of(Arqueiro.class))),
    CAJADO(7, "Cajado", 19, new ArrayList<Class>(List.of(Mago.class))),
    LIVRO_DE_MAGIAS(8, "Livro de Magias", 19, new ArrayList<Class>(List.of(Mago.class))),
    ARMADILHA(9, "Armadilha", 15, new ArrayList<Class>(List.of(Armadilha.class))),
    MACHADO_DUPLO(10, "Machado Duplo", 16, new ArrayList<Class>(List.of(Lider.class)));

    private int id;
    private String nome;
    private int dano;
    private ArrayList<Class> usuariosPermitidos;

    private ArmasEnum(int id, String nome, int dano, ArrayList<Class> usuariosPermitidos) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.usuariosPermitidos = usuariosPermitidos;
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
