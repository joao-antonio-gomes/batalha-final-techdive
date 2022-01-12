package model;

import enums.ArmasEnum;

public class Armadilha {
    private int pontosDeAtaque;
    private ArmasEnum arma;

    public Armadilha() {
        this.arma = ArmasEnum.ARMADILHA;
        this.pontosDeAtaque = this.arma.getDano();
    }
}
