package model;

import enums.ArmasEnum;

public class Armeiro extends Inimigo{
    public Armeiro(int pontosDeVida, int pontosDeAtaque, int pontosDeDefesa, ArmasEnum arma) {
        super(pontosDeVida, pontosDeAtaque, pontosDeDefesa, arma);
    }
}
