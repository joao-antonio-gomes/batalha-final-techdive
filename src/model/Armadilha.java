package model;

import enums.ArmasEnum;

public class Armadilha implements Atacante {
    private int pontosDeAtaque;
    private ArmasEnum arma;

    public Armadilha() {
        this.arma = ArmasEnum.ARMADILHA;
        this.pontosDeAtaque = this.arma.getDano();
    }

    @Override
    public void atacar(Personagem p) {

    }
}
