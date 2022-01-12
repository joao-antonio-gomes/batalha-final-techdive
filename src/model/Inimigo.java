package model;

import enums.ArmasEnum;

abstract public class Inimigo extends Personagem implements Atacante {
    private ArmasEnum arma;
    private static final int pontosDeVida = 100;

    public Inimigo(int pontosDeVida, int pontosDeAtaque, int pontosDeDefesa, ArmasEnum arma) {
        super(pontosDeVida, pontosDeAtaque, pontosDeDefesa);
        this.arma = arma;
    }

    public Inimigo(int pontosDeAtaque, int pontosDeDefesa, ArmasEnum arma) {
        super(pontosDeVida, pontosDeAtaque, pontosDeDefesa);
        this.arma = arma;
    }

    @Override
    public void atacar(Personagem personagem) {

    }
}
