package model;

import enums.ArmasEnum;
import utils.Dado;

import java.util.List;

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
    public void atacar(Personagem defensor) {
        int danoDado = Dado.rolarDado(20);
        int pontosDeAtaque = this.getPontosDeAtaque();
        int danoArma = this.arma.getDano();
        int danoTotal = pontosDeAtaque + danoArma + danoDado;

        int pontosDeDefesa = defensor.getPontosDeDefesa();
        int pontosDeVida = defensor.getPontosDeVida();

        if (danoDado == 1) {
            System.out.println("O inimigo errou o golpe!");
            return;
        }

        if (danoDado == 20) {
            System.out.println("O inimigo acertou um golpe em cheio em você!");
            int pontosDeVidaFinal = pontosDeVida - (danoTotal * 2);
            defensor.setPontosDeVida(pontosDeVidaFinal);
        } else {
            int danoFinal = danoTotal - pontosDeDefesa;
            int pontosDeVidaFinal = pontosDeVida - danoFinal;
            defensor.setPontosDeVida(pontosDeVidaFinal);
        }

        boolean defensorEstaVivo = defensor.getPontosDeVida() > 0;

        System.out.println("Seu inimigo causou " + danoTotal + " de dano!");

        if (defensorEstaVivo) {
            System.out.println("Você permanece de pé!");
            return;
        }

        System.out.println("Você morreu!");
    }
}
